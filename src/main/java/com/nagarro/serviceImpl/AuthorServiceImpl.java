package com.nagarro.serviceImpl;

import com.nagarro.dao.AuthorDAO;
import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDAO authorDOA;

    @Override
    public List<Author> getAll() {
        return authorDOA.getAll();
    }

    @Override
    public Author getById(int id) {
        return authorDOA.getById(id);
    }
}
