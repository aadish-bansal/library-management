package com.nagarro.model;


import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashMap;

public class BookInput {
    @NotBlank(message = "Code can't be blank")
    @Size(min=5,max=50,message = "Code should be length between 5 - 50")
    private String code;
    @NotBlank(message = "Name can't be blank")
    @Size(min=5,max=50,message = "Password should be length between 5 - 50")
    private String name;

    private Integer author;
    private LinkedHashMap<Integer,String> authorNameOptions;

    @Column(name="added on date")
    private String addedDate;


    public LinkedHashMap<Integer, String> getAuthorNameOptions() {
        return authorNameOptions;
    }

    public void setAuthorNameOptions(LinkedHashMap<Integer, String> authorNameOptions) {
        this.authorNameOptions = authorNameOptions;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "BookInput{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", addedDate='" + addedDate + '\'' +
                '}';
    }
}
