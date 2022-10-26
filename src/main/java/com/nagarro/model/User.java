package com.nagarro.model;


public class User {
    private Long id;

    private String name;

    private String pass;

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + pass + '\'' +
                '}';
    }
}
