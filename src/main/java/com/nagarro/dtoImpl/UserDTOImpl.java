package com.nagarro.dtoImpl;

import com.nagarro.dto.UserDTO;
import com.nagarro.model.LoginCredentials;
import com.nagarro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class UserDTOImpl implements UserDTO {

    @Autowired
    UserService userService;

    @Override
    public boolean checkValidUser(LoginCredentials loginCredentials) {
        LinkedHashMap<String,String> usersList=new LinkedHashMap<>();
        userService.getAll().forEach(item->usersList.put(item.getName(), item.getPassword()));
        final boolean[] flag = {false};
        usersList.forEach((k,v)->{
            if(loginCredentials.getName().equals(k)&&loginCredentials.getPassword().equals(v)){
                flag[0] =true;
            }
        });
        return flag[0];
    }
}
