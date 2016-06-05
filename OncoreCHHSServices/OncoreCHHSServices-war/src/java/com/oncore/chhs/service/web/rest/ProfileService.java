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
package com.oncore.chhs.service.web.rest;

import com.oncore.chhs.client.dto.profile.Profile;
import com.oncore.chhs.ejb.EJBUtils;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

/**
 * This class provides RESTful services for Profile functionality.
 * 
 * @author oncore
 */
@Provider
@Path("Profile")
public class ProfileService {
    
    @Context
    private UriInfo context;
    
    /**
     * Default constructor.
     */
    public ProfileService() {
        
    }
    
    @GET
    @Path("/findProfileByUserUid/")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public Profile findByUserUid( @QueryParam("id") Integer userUid)
    {
        return this.getEjbProfileService().findProfileByUserUid(userUid);
    }
    
    /**
     * Get the EJB service that will handle the request.
     * Package level to allow access by unit tests.
     * 
     * @return The EJB ProfileService.
     */
    com.oncore.chhs.client.ejb.ProfileService getEjbProfileService()
    {
        return EJBUtils.lookupEJB(com.oncore.chhs.client.ejb.ProfileService.class );
    }
}