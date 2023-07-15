package com.example.copyioc;

import com.example.copyioc.service.User;
import com.example.copyioc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
//@SpringBootApplication
public class CopyIocApplication {


    public static void main(String[] args) {
//        ApplicationContext context =new AnnotationConfigApplicationContext(CopyIocApplication.class);
        ApplicationContext context =new ClassPathXmlApplicationContext("application.xml");

        UserService userService=context.getBean(UserService.class);
        User user=userService.login("bob@example.com", "password");
        System.out.println(user.getName());
    }


}
