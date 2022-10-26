package com.nagarro.dto;

import com.nagarro.model.LoginCredentials;

public interface UserDTO {

    public boolean checkValidUser(LoginCredentials loginCredentials);

}
