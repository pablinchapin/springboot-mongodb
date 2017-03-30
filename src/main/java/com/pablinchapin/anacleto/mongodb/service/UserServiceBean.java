/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.service;

import com.pablinchapin.anacleto.mongodb.exception.UserNotFoundException;
import com.pablinchapin.anacleto.mongodb.model.User;
import com.pablinchapin.anacleto.mongodb.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pvargas
 */
@Service("userService")
@Transactional
public class UserServiceBean implements UserService{
    
    private static final Log log = LogFactory.getLog(UserServiceBean.class);
    
    public UserRepository userRepository;
    
    @Autowired
    public UserServiceBean(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        Optional<List<User>> users = userRepository.findAll();
        
        return users.get();
    }

    @Override
    public User findByUserId(String userId) {
        Optional<User> user = userRepository.findOne(userId);
        
        if(user.isPresent()){
            log.debug(String.format("Read userId '{}'", userId));
            return user.get();
        }else{
                throw new UserNotFoundException(userId);
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }
    
    
}
