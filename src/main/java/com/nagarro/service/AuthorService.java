package com.nagarro.service;

import com.nagarro.model.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> getAll();
    public Author getById(int id);


}
