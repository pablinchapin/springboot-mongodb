/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.repository;

import com.pablinchapin.anacleto.mongodb.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.util.Assert;

/**
 *
 * @author pvargas
 */
@Repository
public class UserRepositoryBean implements UserRepository {

    private final MongoOperations mongoOperations;
    
    @Autowired
    public UserRepositoryBean(MongoOperations mongoOperations){
        //Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }
    
    
    @Override
    public Optional<List<User>> findAll() {
        List<User> users = this.mongoOperations.find(new Query(), User.class);
        Optional<List<User>> optionalUsers = Optional.ofNullable(users);
        
        return optionalUsers;
    }

    @Override
    public Optional<User> findOne(String userId) {
        User docu = this.mongoOperations.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
        Optional<User> user = Optional.ofNullable(docu);
        
        return user;
    }

    @Override
    public User saveUser(User user) {
        this.mongoOperations.save(user);
        
        return findOne(user.getUserId()).get();
    }

    @Override
    public void updateUser(User user) {
        this.mongoOperations.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where(userId).is(userId)), User.class);
    }
    
}