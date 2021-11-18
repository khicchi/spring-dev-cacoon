package com.lespania.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;  //first_name
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddres")
    private String email;

}
