package com.lespania.controller;

import com.lespania.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String employeeCreate(Model model){

        model.addAttribute("employee",new Employee());


        return "employee/employee-create";
    }

}
