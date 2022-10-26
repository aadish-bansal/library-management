package com.nagarro.dto;

import com.nagarro.model.Book;
import com.nagarro.model.BookInput;


public interface BookDTO {
    public Book getBookObject(BookInput bookInput);

    public boolean checkValidId(BookInput bookInput);

}
