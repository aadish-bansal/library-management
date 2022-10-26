package com.nagarro.dtoImpl;

import com.nagarro.dto.BookDTO;
import com.nagarro.model.Book;
import com.nagarro.model.BookInput;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDTOImpl implements BookDTO {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Override
    public Book getBookObject(BookInput bookInput) {
        Book book= new Book();
        book.setId(Integer.valueOf(bookInput.getCode()));
        book.setDate(bookInput.getAddedDate());
        book.setName(bookInput.getName());
        book.setAuthor( authorService.getById(bookInput.getAuthor()));
        return book;
    }

    @Override
    public boolean checkValidId(BookInput bookInput) {
        List<Book> all = bookService.getAll();
        List<Integer> idsList = new ArrayList<>();
        all.forEach(item->idsList.add(item.getId()));
        return idsList.contains( Integer.parseInt( bookInput.getCode()));
    }


}
