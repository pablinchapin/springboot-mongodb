/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.repository;

import com.pablinchapin.anacleto.mongodb.model.User;
import java.util.List;
import java.util.Optional;



/**
 *
 * @author pvargas
 */
public interface UserRepository {
    
    
    Optional<List<User>> findAll();
    
    public Optional<User> findOne(String userId);
    
    public User saveUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUser(String userId);
    
}