/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.controller;

import com.pablinchapin.anacleto.mongodb.exception.UserNotFoundException;
import com.pablinchapin.anacleto.mongodb.model.User;
import com.pablinchapin.anacleto.mongodb.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pvargas
 */
@RestController
@RequestMapping("users")
public class UserController {
    
    private static final Log log = LogFactory.getLog(UserController.class);
    
    private final UserService usersService;
    private User user;
    
    @Autowired
    public UserController(UserService usersService){
        this.usersService = usersService;
    }
    
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> userById(){
        log.info("Get All users");
        return ResponseEntity.ok(usersService.findAll());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> userById(@PathVariable String userId) throws UserNotFoundException{
        log.info("Get userById");
        try{
            user = usersService.findByUserId(userId);
        }catch(UserNotFoundException e){
            log.warn(e);
            user = null;
        }
        return ResponseEntity.ok(user);
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
        log.info("Save new user");
        return ResponseEntity.ok(usersService.saveUser(user));
    }
    
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody @Valid User user){
        log.info("update user" + user.getUserId());
        
        usersService.updateUser(user);
        
        return ResponseEntity.noContent().build();
    }
    
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        log.info("Delete user "+userId);
        usersService.deleteUser(userId);
        
        return ResponseEntity.noContent().build();
    }
    
}