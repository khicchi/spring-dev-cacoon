package com.lespania.controller;

import com.lespania.entity.Student;
import com.lespania.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    Student getStudent_service(){
        Student student = new Student("Mike","Smith",20);
        return student;
    }

    @GetMapping("/data")
    List<Student> getStudent_data(){
        return  studentService.getStudent_data();
    }




}
