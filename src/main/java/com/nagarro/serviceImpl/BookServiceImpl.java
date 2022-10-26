package com.nagarro.serviceImpl;

import com.nagarro.dao.BookDAO;
import com.nagarro.dto.BookDTO;
import com.nagarro.model.Book;
import com.nagarro.model.BookInput;
import com.nagarro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDOA;

    @Autowired
    BookDTO bookDTO;

    @Override
    public List<Book> getAll() {
        return bookDOA.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDOA.getById(id);
    }

    @Override
    public void add(Book book) {
        bookDOA.add(book);
    }

    @Override
    public void update(Book book, int id) {
        bookDOA.update(book,id);
    }

    @Override
    public void delete(int id) {
        bookDOA.delete(id);
    }

    @Override
    public Book getBookObject(BookInput bookInput) {
        return bookDTO.getBookObject(bookInput);
    }

    @Override
    public boolean checkValidId(BookInput bookInput) {
        return bookDTO.checkValidId(bookInput);
    }

}
