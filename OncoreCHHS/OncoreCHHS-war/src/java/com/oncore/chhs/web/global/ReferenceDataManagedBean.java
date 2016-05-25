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
package com.oncore.chhs.web.global;

import com.oncore.chhs.web.entities.AdrStateCd;
import com.oncore.chhs.web.entities.EmcTypeCd;
import com.oncore.chhs.web.exceptions.WebServiceException;
import com.oncore.chhs.web.services.AdrStateCdFacadeREST;
import com.oncore.chhs.web.services.EmcTypeCdFacadeREST;
import com.oncore.chhs.web.utils.ErrorUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author oncore
 */
@Named("referenceDataManagedBean")
@RequestScoped
public class ReferenceDataManagedBean implements AbstractReferenceDataManagedBean {

    @EJB
    private AdrStateCdFacadeREST adrStateCdFacadeREST;

    @EJB
    private EmcTypeCdFacadeREST emcTypeCdFacadeREST;

//     @Override
//    public Users createUser(ProfileBean profileBean) throws WebServiceException {
//        
//        Users users = new Users();
//        
//        try {
//            
//            users.setCreateUserId(profileBean.getUserName());
//            users.setCreateTs(new Date());
//            users.setUpdateUserId(profileBean.getUserName());
//            users.setUpdateTs(new Date());
//            users.setUsrFirstname(profileBean.getFirstName());
//            users.setUsrMiddlename(profileBean.getMiddleName());
//            users.setUsrLastname(profileBean.getLastName());
//            users.setUsrUserId(profileBean.getUserName());
//            
//            usersFacadeREST.create(users);
//            
//        } catch (Exception ex) {
//            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
//        }
//
//        return users;
//    }
//    
//    
//    @Override
//    public Users authenticateUser(LoginBean loginBean) throws WebServiceException {
//
//        Users users = null;
//
//        try {
//            users = usersFacadeREST.findByUserId(loginBean.getUserName());
//        } catch (Exception ex) {
//            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
//        }
//
//        return users;
//    }
    @Override
    @PostConstruct
    public void initialize() {
        LOG.debug("Initializing ReferenceDataManagedBean: " + this.getClass().hashCode());
    }

    @Override
    @PreDestroy
    public void destroy() {
        LOG.debug("Destroying ReferenceDataManagedBean: " + this.getClass().hashCode());
    }

    @Override
    public List<AdrStateCd> fetchStateCodes() throws WebServiceException {
        List<AdrStateCd> stateCodes = new ArrayList<>(1);

        try {
            stateCodes = this.adrStateCdFacadeREST.findAll();
        } catch (Exception ex) {
            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
        }

        return stateCodes;
    }

    @Override
    public List<EmcTypeCd> fetchContactCodes() throws WebServiceException {
        List<EmcTypeCd> contactCodes = new ArrayList<>(1);

        try {
            contactCodes = this.emcTypeCdFacadeREST.findAll();
        } catch (Exception ex) {
            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
        }

        return contactCodes;
    }

    private final Logger LOG = LogManager.getLogger(ReferenceDataManagedBean.class);

}