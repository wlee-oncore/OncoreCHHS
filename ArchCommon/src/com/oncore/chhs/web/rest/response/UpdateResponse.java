/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oncore.chhs.web.rest.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kerry O'Brien
 */
@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
public class UpdateResponse extends AbstractUpdateResponse {
    
    /**
     * 
     */
    public UpdateResponse( ) {
        
    }
    
    /**
     * 
     * @param numberItemsAffected The number items affected.
     */
    public UpdateResponse( int numberItemsAffected ) {
        super( numberItemsAffected );
    }
    
   /**
     * 
     * @param errorMessage The error message.
     * @param cause The cause.
     */
    public UpdateResponse( String errorMessage, Throwable cause ) {
       super( errorMessage, cause );
    }
}