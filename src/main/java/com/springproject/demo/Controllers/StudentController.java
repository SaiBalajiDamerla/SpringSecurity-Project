package com.springproject.demo.Controllers;

import com.springproject.demo.Model.Students;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    List<Students> students = new ArrayList<>(List.of(
         new Students(1, "sai", 20),
         new Students(2,"balaji",34)  ,
         new Students(3,"dsav",423)
    ));

    @GetMapping("Csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest req) {
       return (CsrfToken) req.getAttribute("_csrf");


    }
    @GetMapping("student")
    public List<Students> student() {
        return students;
    }

    @PostMapping("AddStudent")
    public List<Students> addStudent(@RequestBody Students studen)
    {
        students.add(studen);
        return students;
    }

}
