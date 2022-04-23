package com.uuu.demo1.controllers;

import com.uuu.demo1.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @Autowired
    GreetingService service;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Hello World");
        return "home";
    }


    @RequestMapping("/greeting")
    public @ResponseBody String greeting(Model model){

        return service.greet();
    }

}
