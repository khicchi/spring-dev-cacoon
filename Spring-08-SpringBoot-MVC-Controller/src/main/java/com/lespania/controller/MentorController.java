package com.lespania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    //input: http://localhost:8080/mentor/show
    //output: show from mentor
    @GetMapping("/show")
    public String showForm(){
        System.out.println("show from mentor");
        return "home";
    }
}
