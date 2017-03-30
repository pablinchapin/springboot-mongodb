package com.pablinchapin.anacleto.mongodb.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pvargas
 */
@Document(collection = "users")
@JsonPropertyOrder({"userId", "name"})
public class User implements Serializable {
    
    private static final long serialVersionUID = -7788619177798333712L;
    
    @Id
    @NotNull
    private String userId;
    @NotNull
    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
