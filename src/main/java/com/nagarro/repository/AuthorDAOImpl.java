package com.nagarro.repository;

import com.nagarro.component.RestTemplateBean;
import com.nagarro.dao.AuthorDAO;
import com.nagarro.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
    @Autowired
    RestTemplateBean restTemplateBean;
    private String baseUrl = "http://localhost:8081/authors";

    @Override
    public List<Author> getAll() {
        Author[] forObject = new Author[0];
        try {
            forObject = this.restTemplateBean.restTemplate.getForObject(baseUrl, Author[].class);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Not found");
        }
        return List.of(forObject);
    }


    @Override
    public Author getById(int id) {
        String url = baseUrl + "/" + id;
        Author forObject = null;
        try {
            forObject = this.restTemplateBean.restTemplate.getForObject(url, Author.class);
        } catch (Exception e) {
            System.out.println("Not found");
        }
        return forObject;
    }
}
