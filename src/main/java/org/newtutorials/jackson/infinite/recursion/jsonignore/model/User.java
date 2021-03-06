package org.newtutorials.jackson.infinite.recursion.jsonignore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by dani on 5/21/2017.
 */
public class User {
    private String name;
    @JsonIgnore
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

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
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
