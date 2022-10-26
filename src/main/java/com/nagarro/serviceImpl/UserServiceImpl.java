package com.nagarro.serviceImpl;

import com.nagarro.dao.UserDAO;
import com.nagarro.dto.UserDTO;
import com.nagarro.model.LoginCredentials;
import com.nagarro.model.User;
import com.nagarro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserDTO userDTO;

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public boolean checkValidUser(LoginCredentials loginCredentials) {
        return userDTO.checkValidUser(loginCredentials);
    }
}