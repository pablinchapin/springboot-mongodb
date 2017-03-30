/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.exception;

import org.springframework.core.NestedRuntimeException;

/**
 *
 * @author pvargas
 */
public class UserNotFoundException extends NestedRuntimeException {
    
    public UserNotFoundException(String userId){
        super(String.format("User with Id '%s' not founded", userId));
    }
    
}