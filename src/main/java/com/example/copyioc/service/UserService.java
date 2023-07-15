package com.example.copyioc.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <p>标题： </p>
 * <p>功能： </p>
 * <p>版权： Copyright (c) 2023</p>
 * <p>创建日期：7/12/23 5:36 PM</p>
 * <p>类全名：com.example.copyioc.service.UserService</p>
 */

//@Configuration
//@Component
public class UserService {

//    @Autowired
   private MailService mailService;

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }


//    public UserService(@Autowired MailService mailService){
//        this.mailService=mailService;
//    }
    

//    private List<User> users=new ArrayList<>(List.of(
//            new User(1,"bob@example.com","password","Bob"),
//            new User(2,"alice@example.com","password","Alice"),
//            new User(3,"tom@example.com","password","Tom")
//    ));

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "bob@example.com", "password", "Bob"),
            new User(2, "alice@example.com", "password", "Alice"),
            new User(3, "tom@example.com", "password", "Tom")
    ));

    //    public User login(String email,String password){
//        for(User user:users){
//            if(User.getEmail().equalsIgnoreCase(email)&&user.getPassword().equals(password)){
//                mailService.sendLoginMail(user);
//                return user;
//            }
//        }
//        throw new RuntimeException("login failed.");
//    }
public User login(String email, String password) {
    for (User user : users) {
        if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
            mailService.sendLoginMail(user);
            return user;
        }
    }
    throw new RuntimeException("login failed.");
}


//    public User getUser(long id){
//        return this.users.stream().filter(user->user.getId()==id).findFirst().orElseThrow();
//    }
//public User getUser(long id) {
//    return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
//}

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public User register (String email ,String password,String name){
        users.forEach((User)->{
            if(User.getEmail().equalsIgnoreCase(email)){
                throw new RuntimeException("email exist.");
            }
        });

        User user=new User(users.stream().mapToLong(u->u.getId()).max().getAsLong(),email,password,name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return  user;
    }
}
