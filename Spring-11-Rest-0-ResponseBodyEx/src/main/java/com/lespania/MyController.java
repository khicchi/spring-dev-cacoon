package com.lespania;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/getWelcomePage")
    public String returnWebPage(){
        return "/welcome";
    }

    @GetMapping("/getWelcomeMessageAsBody")
    @ResponseBody
    public String getWelcomeMessageAsBody(){
        return "welcome to body";
    }

}
