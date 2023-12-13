package com.dailycodebuffer.springbootbasic.controller;

import com.dailycodebuffer.springbootbasic.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("Sudhir");
        user.setEmail("sudhir@salesken.ai");
        return user;
    }

    @GetMapping("/user/{name}/{id}")
    public User getUserBYPathVariable(@PathVariable String name, @PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @GetMapping("/user/params")
    public User userBYRequestParams(@RequestParam Integer id , @RequestParam String name ,
                                    @RequestParam(required = false) String email){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }

}
