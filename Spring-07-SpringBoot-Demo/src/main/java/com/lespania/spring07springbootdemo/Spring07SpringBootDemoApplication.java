package com.lespania.spring07springbootdemo;

import com.lespania.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.lespania")
public class Spring07SpringBootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(Spring07SpringBootDemoApplication.class, args);

        Course course = container.getBean("java", Course.class);

        System.out.println(course.getTeachingHours());
    }

}
