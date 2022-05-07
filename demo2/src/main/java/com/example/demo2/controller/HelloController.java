package com.example.demo2.controller;

import com.example.demo2.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Message message;

    @RequestMapping("hello")
    Message home(){

//        Message message = new Message();
        message.setId(888);
        message.setName("Hello");
        return message;
    }
}
