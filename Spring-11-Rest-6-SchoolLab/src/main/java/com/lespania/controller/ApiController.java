package com.lespania.controller;

import com.lespania.model.Teacher;
import com.lespania.repository.AddressRepository;
import com.lespania.repository.ParentRepository;
import com.lespania.repository.StudentRepository;
import com.lespania.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> redAllTeachers(){
        return teacherRepository.findAll();
    }

}
