package com.springproject.demo.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(" ")
    public String home() {
        return "Hello balaji";
    }

@GetMapping("hello")
    public String greet() {
    return "Hello World";

    }

    @GetMapping("hi")
    public String welcome(HttpServletRequest request){
    return "Hi World "+ request.getSession().getId();
    }
}
