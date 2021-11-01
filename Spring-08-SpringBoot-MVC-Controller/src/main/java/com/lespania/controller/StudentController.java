package com.lespania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    //input: http://localhost:8080/student/show
    //output: show from student
    @GetMapping("/show")
    public String showForm(){
        System.out.println("show from student");
        return "home";
    }
}
