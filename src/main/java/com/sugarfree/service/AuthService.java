package com.sugarfree.service;


import com.sugarfree.configuration.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
