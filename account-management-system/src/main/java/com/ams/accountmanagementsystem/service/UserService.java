package com.ams.accountmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.ams.accountmanagementsystem.model.User;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    private Map<String, User> users;

    public UserService() {
       
    }
    public Map<String, User> getUsers() {
        return users;
    }
    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

// Method to check whether the customer exists or not based on customer id
    public boolean customerExists(String customerId) {
        User user = getUser(customerId);
        return user != null;
    }

// Method to get users using customer id 
    public User getUser(String customerId) {
        User user = users.get(customerId);
        
        if (user == null) {
            logger.log(Level.WARNING, "User with ID " + customerId + " does not exist.");
        } else {
            logger.log(Level.INFO, "User found: " + user.toString());
        }
        
        return user;
    }
}