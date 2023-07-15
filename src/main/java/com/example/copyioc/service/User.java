package com.example.copyioc.service;

/**
 * <p>标题： </p>
 * <p>功能： </p>
 * <p>版权： Copyright (c) 2023</p>
 * <p>创建日期：7/12/23 5:36 PM</p>
 * <p>类全名：com.example.copyioc.service.User</p>
 */
public class User {

    private long id;
    private String email;
    private String password;
    private String name;

    public User(long id ,String email,String password,String name){
        this.id=id;
        this.email=email;
        this.password=password;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
