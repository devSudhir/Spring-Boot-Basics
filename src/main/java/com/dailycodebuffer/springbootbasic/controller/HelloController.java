package com.dailycodebuffer.springbootbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/home")
    public  String homePath(){
        return "Home Page";
    }
}
