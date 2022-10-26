package com.nagarro.service;

import com.nagarro.model.Book;
import com.nagarro.model.BookInput;

import java.util.List;

public interface BookService {
    public List<Book> getAll();

    public Book getById(int id);

    public void add(Book book);

    public void update(Book book, int id);

    public void delete(int id);
    public Book getBookObject(BookInput bookInput);

    public boolean checkValidId(BookInput bookInput);

}
