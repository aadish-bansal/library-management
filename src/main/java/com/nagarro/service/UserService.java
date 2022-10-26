package com.nagarro.service;

import com.nagarro.model.LoginCredentials;
import com.nagarro.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public boolean checkValidUser(LoginCredentials loginCredentials);

}
