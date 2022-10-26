package com.nagarro.repository;

import com.nagarro.dao.BookInputDAO;
import com.nagarro.model.Author;
import com.nagarro.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public class BookInputDAOImpl implements BookInputDAO {
    @Autowired
    AuthorService authorService;
    @Override
    public LinkedHashMap<Integer,String> populateAuthorName(){
        List<Author> all = authorService.getAll();
        LinkedHashMap<Integer,String> temp= new LinkedHashMap<>();
        for (int i = 0; i <all.size() ; i++) {
            temp.put(all.get(i).getId(), all.get(i).getName());
        }
        return temp;
   }
    @Override
    public String setCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        return dateFormat.format(new Date());
    }
}
