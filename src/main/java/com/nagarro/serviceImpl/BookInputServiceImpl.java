package com.nagarro.serviceImpl;

import com.nagarro.dao.BookInputDAO;
import com.nagarro.dto.BookInputDTO;
import com.nagarro.model.BookInput;
import com.nagarro.service.BookInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class BookInputServiceImpl implements BookInputService {
    @Autowired
    BookInputDAO bookInputDAO;

    @Autowired
    BookInputDTO bookInputDTO;
    @Override
    public LinkedHashMap<Integer,String> populateAuthorName() {
        return bookInputDAO.populateAuthorName();
    }

    @Override
    public String setCurrentDate() {
        return bookInputDAO.setCurrentDate();
    }

    @Override
    public BookInput getBookInputObject(int id) {
        return bookInputDTO.getBookInputObject(id);
    }
}
