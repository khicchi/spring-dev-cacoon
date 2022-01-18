package com.lespania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tester")
public class TesterController {

    @GetMapping("/getWelcomePage")
    public String welcome(){
        return "welcome";
    }

}
