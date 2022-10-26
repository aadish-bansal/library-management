package com.nagarro.dtoImpl;

import com.nagarro.dto.BookInputDTO;
import com.nagarro.model.Book;
import com.nagarro.model.BookInput;
import com.nagarro.service.BookInputService;
import com.nagarro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookInputDTOImpl implements BookInputDTO {

    @Autowired
    BookService bookService;
    @Autowired
    BookInputService bookInputService;
    @Override
    public BookInput getBookInputObject(int id) {
        Book byId = bookService.getById(id);
        BookInput bookInput=new BookInput();
        bookInput.setCode(String.valueOf(byId.getId()));
        bookInput.setName(byId.getName());
        bookInput.setAuthorNameOptions(bookInputService.populateAuthorName());
        bookInput.setAddedDate(byId.getDate());
        return bookInput;
    }
}
