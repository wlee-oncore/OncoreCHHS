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
package com.oncore.chhs.web.login;

import com.oncore.chhs.client.dto.User;
import com.oncore.chhs.client.rest.UsersServiceClient;
import com.oncore.chhs.web.exceptions.WebServiceException;
import com.oncore.chhs.web.profile.ProfileBean;
import com.oncore.chhs.web.services.UsersFacadeREST;
import com.oncore.chhs.web.utils.ErrorUtils;
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
@Named("loginDataManagedBean")
@RequestScoped
public class LoginDataManagedBean implements AbstractLoginDataManagedBean {

    @EJB
    private UsersFacadeREST usersFacadeREST;

    /**
     * Package level setter used for passing in mock objects for unit tests.
     *
     * @param mockObject The mock EJB to use for testing.
     */
    void setUsersFacadeREST(UsersFacadeREST mockObject) {
        this.usersFacadeREST = mockObject;
    }

    @Override
    public User createUser(ProfileBean profileBean) throws WebServiceException {

        User user = new User();

        try {

            //TODO:  UPDATE TO USE NEW WEB SERVICE CLIENT
//            user.setCreateUserId(profileBean.getUserName());
//            user.setCreateTs(new Date());
//            user.setUpdateUserId(profileBean.getUserName());
//            user.setUpdateTs(new Date());
//            user.setUsrFirstname(profileBean.getFirstName());
//            user.setUsrMiddlename(profileBean.getMiddleName());
//            user.setUsrLastname(profileBean.getLastName());
//            user.setUsrUserId(profileBean.getUserName());
//            user.setUsrPassword("notused");
//
//            usersFacadeREST.create(user);

        } catch (Exception ex) {
            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
        }

        return user;
    }

    @Override
    public User authenticateUser(LoginBean loginBean) throws WebServiceException {

        User users = null;

        try {
            users = this.getUsersServiceClient().authenticateUser(loginBean.getUserName());
        } catch (Exception ex) {
            throw new WebServiceException(ErrorUtils.getStackTrace(ex));
        }

        return users;
    }

    @Override
    @PostConstruct
    public void initialize() {
        LOG.debug("Initializing LoginDataManagedBean: " + this.getClass().hashCode());
    }

    @Override
    @PreDestroy
    public void destroy() {
        LOG.debug("Destroying LoginDataManagedBean: " + this.getClass().hashCode());
    }

    private final Logger LOG = LogManager.getLogger(LoginDataManagedBean.class);

    /**
     *
     * @return UsersServiceClient
     */
    UsersServiceClient getUsersServiceClient() {

        return new UsersServiceClient();
    }

}
