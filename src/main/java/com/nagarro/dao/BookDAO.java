package com.nagarro.dao;



import com.nagarro.model.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getAll();

    public Book getById(int id);

    public void add(Book book);

    public void update(Book book,int id);

    public void delete(int id);


}
