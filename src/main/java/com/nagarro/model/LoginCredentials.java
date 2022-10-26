package com.nagarro.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginCredentials {
    @NotNull(message = "Username can't be blank")
    @Size(min=5,max=50,message = "Username should be length between 5 - 50")
    private String name;
    @NotBlank(message = "Password can't be blank")
    @Size(min=5,max=50,message = "Password should be length between 5 - 50")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
