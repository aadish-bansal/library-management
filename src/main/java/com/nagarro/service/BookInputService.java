package com.nagarro.service;


import com.nagarro.model.BookInput;

import java.util.LinkedHashMap;

public interface BookInputService {
    public LinkedHashMap<Integer,String> populateAuthorName();
    public String setCurrentDate();

    public BookInput getBookInputObject(int id);

}
