package com.nagarro.repository;

import com.nagarro.dao.BookDAO;
import com.nagarro.component.RestTemplateBean;
import com.nagarro.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    RestTemplateBean restTemplateBean;

    private String baseUrl="http://localhost:8081/books";

    @Override
    public List<Book> getAll() {

        Book[] forObject = new Book[0];
        try {
            forObject = this.restTemplateBean.restTemplate.getForObject(baseUrl, Book[].class);
        } catch (Exception e) {
            System.out.println("Not found");
        }
        return List.of(forObject);
    }

    @Override
    public Book getById(int id) {
        String url=baseUrl+"/"+ id;
        Book forObject = null;
        try {
            forObject = this.restTemplateBean.restTemplate.getForObject(url, Book.class);
        } catch (Exception e) {
            System.out.println("Not found");
        }
        return forObject;
    }

    @Override
    public void add(Book book) {
        this.restTemplateBean.restTemplate.postForLocation(baseUrl,book);
    }

    @Override
    public void update(Book book, int id) {
        String url=baseUrl+"/"+id;
        this.restTemplateBean.restTemplate.put(url,book);
    }

    @Override
    public void delete(int id) {
        String url=baseUrl+"/"+id;
        this.restTemplateBean.restTemplate.delete(url);
    }
}
