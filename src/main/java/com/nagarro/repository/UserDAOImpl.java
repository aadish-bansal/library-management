package com.nagarro.repository;

import com.nagarro.component.RestTemplateBean;
import com.nagarro.dao.UserDAO;
import com.nagarro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    RestTemplateBean restTemplateBean;

    private String baseUrl = "http://localhost:8081/users";

    @Override
    public List<User> getAll() {
        User[] forObject = this.restTemplateBean.restTemplate.getForObject(baseUrl, User[].class);
        return List.of(forObject);
    }

}