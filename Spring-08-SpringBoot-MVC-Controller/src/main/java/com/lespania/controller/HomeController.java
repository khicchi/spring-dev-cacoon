package com.lespania.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/kicchi")
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/kicchi")
    public String getRequestMapping3(){
        return "home";
    }

//    @GetMapping("/spring")
//    public String getMappingEx(){
//        return "home";
//    }

    @PostMapping("/spring")
    public String getMappingEx2(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("name is: " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name, @PathVariable("email") String email){
        System.out.println("name is: " + name);
        System.out.println("email is: " + email);
        return "home";
    }

    @GetMapping("home/course")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("name is :" + course);
        return "home";
    }

    //input : http://localhost:8080/home/course2
    //output: name is: kicchi

    //input: http://localhost:8080/home/course2?course2=tata
    //output: name is: tata
    @GetMapping("home/course2")
    public String requestParam2(@RequestParam(value = "course2",required = false,defaultValue = "kicchi") String name){
        System.out.println("name is: " + name);
        return "home";
    }

    //input: http://localhost:8080/coursez?name=yaya
    //output: name from coursez is: yaya

    //input: http://localhost:8080/coursez
    //output: name from coursez is: kicchi
    @GetMapping(value = "coursez")
    public String requestParam3(@RequestParam(value = "name", required = false, defaultValue = "kicchi")String name){
        System.out.println("name from coursez is: " + name);
        return "home";
    }

}
