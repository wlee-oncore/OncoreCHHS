/*
 * The MIT License
 *
 * Copyright 2016 oncore.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.oncore.chhs.web.filters;

import com.oncore.chhs.web.global.GlobalManagedBean;
import java.io.IOException;
import java.util.Date;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author oncore
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class SessionFilter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            Boolean isLogoutRequest = httpRequest.getRequestURI().contains("logout.xhtml");
            Boolean isResourceRequest = httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);
            Boolean isSessionValid = (httpRequest.getRequestedSessionId() != null) && !httpRequest.isRequestedSessionIdValid();

            if (isSessionValid) {

                if (!isResourceRequest) {
                    if (isLogoutRequest) {
                        this.globalManagedBean.setAuthenticated(Boolean.FALSE);
                        httpRequest.getSession(false).setMaxInactiveInterval(1);
                        httpRequest.getSession(false).invalidate();
                        httpRequest.logout();

                        httpResponse.sendRedirect("index");
                    } else {
                        httpResponse.setHeader("Cache-Control", "private, max-age=432000, no-cache");
                        httpResponse.setHeader("Pragma", "no-cache");
                        httpResponse.setDateHeader("Last-Modified", (new Date()).getTime());

                        this.globalManagedBean.setAuthenticated(Boolean.TRUE);
                    }
                }

                if (!httpResponse.isCommitted()) {
                    chain.doFilter(httpRequest, httpResponse);
                }

            }

        } catch (IOException ix) {
            LOG.debug(ix.getMessage());
        } catch (ServletException sx) {
            LOG.debug(sx.getMessage());
        } catch (javax.enterprise.context.ContextNotActiveException cx) {
            LOG.debug(cx.getMessage());
        } catch (Exception ex) {
            LOG.debug(ex.getMessage());
        }
    }

    @Inject
    GlobalManagedBean globalManagedBean;

    private final Logger LOG = LogManager.getLogger(SessionFilter.class);
}
