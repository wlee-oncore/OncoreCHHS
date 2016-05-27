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
package com.oncore.chhs.web.profile;

import com.oncore.chhs.web.entities.Users;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

/**
 *
 * @author oncore
 */
public class ProfileDataManagedBeanTest {

    /**
     * Test of findProfileByUserUid method, of class ProfileDataManagedBean.
     */
    @Test
    public void testFindProfileByUserUid() throws Exception {
        System.out.println("findProfileByUserUid");
        Integer userUid = null;
        ProfileDataManagedBean instance = new ProfileDataManagedBean();
        ProfileBean expResult = null;
        ProfileBean result = instance.findProfileByUserUid(userUid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProfile method, of class ProfileDataManagedBean.
     */
    @Test
    public void testCreateProfile() throws Exception {
        System.out.println("createProfile");
        ProfileBean profileBean = null;
        Users user = null;
        ProfileDataManagedBean instance = new ProfileDataManagedBean();
        instance.createProfile(profileBean, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProfile method, of class ProfileDataManagedBean.
     */
    @Test
    public void testUpdateProfile() throws Exception {
        System.out.println("updateProfile");
        ProfileBean profileBean = null;
        Users users = null;
        ProfileDataManagedBean instance = new ProfileDataManagedBean();
        instance.updateProfile(profileBean, users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
