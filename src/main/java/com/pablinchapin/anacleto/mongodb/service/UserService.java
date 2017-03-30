/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.service;

import com.pablinchapin.anacleto.mongodb.model.User;
import java.util.List;

/**
 *
 * @author pvargas
 */
public interface UserService {
    
    List<User> findAll();
    
    User findByUserId(String userId);
    
    User saveUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(String userId);
    
}