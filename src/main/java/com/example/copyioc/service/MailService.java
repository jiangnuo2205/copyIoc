package com.example.copyioc.service;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>标题： </p>
 * <p>功能： </p>
 * <p>版权： Copyright (c) 2023</p>
 * <p>创建日期：7/12/23 5:35 PM</p>
 * <p>类全名：com.example.copyioc.service.MailService</p>
 */


public class MailService {
    private  ZoneId zoneId =ZoneId.systemDefault();

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public String getTime(){
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public  void  sendLoginMail(User user){
        System.err.println(String.format("Hi, %s! You are logged in at %s",user.getName(),getTime()));
    }

    public  void sendRegistrationMail(User user){
        System.err.println(String.format("Welcome, %s!",user.getName()));
    }
}
