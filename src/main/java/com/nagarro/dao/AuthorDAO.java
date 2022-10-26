package com.nagarro.dao;


import com.nagarro.model.Author;

import java.util.List;

public interface AuthorDAO {
    public List<Author> getAll();

    public Author getById(int id) ;
}
