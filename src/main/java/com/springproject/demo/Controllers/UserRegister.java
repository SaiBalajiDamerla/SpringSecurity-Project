package com.springproject.demo.Controllers;

import com.springproject.demo.Model.User;
import com.springproject.demo.Service.UserRegisteration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegister {

    @Autowired
    private  UserRegisteration userRegisteration;



    @PostMapping("register")
    public User Register(@RequestBody User user) {
        userRegisteration.registerUser(user);
        return  user;

    }
}
