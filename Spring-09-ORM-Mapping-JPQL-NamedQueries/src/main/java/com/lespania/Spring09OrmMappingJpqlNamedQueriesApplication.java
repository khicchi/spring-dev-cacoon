package com.lespania;

import com.lespania.repository.DepartmentRepository;
import com.lespania.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring09OrmMappingJpqlNamedQueriesApplication {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmMappingJpqlNamedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testEmployee(){

        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu").get());
        employeeRepository.updateEmployeeJPQL(1);

        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));

        System.out.println(departmentRepository.findOzzyDepartment("Kids"));

        System.out.println(departmentRepository.countAllDepartments());
    }

}
