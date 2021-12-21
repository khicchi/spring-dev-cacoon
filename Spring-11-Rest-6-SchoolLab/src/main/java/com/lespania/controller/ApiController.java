package com.lespania.controller;

import com.lespania.repository.AddressRepository;
import com.lespania.repository.ParentRepository;
import com.lespania.repository.StudentRepository;
import com.lespania.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RestController;

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

}
