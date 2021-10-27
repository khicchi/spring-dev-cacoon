package com.lespania;

import com.lespania.interfaces.*;
import com.lespania.services.*;
import com.lespania.configs.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(MyAppClass.class);

        Course course = container.getBean("java", Course.class);

        System.out.println(course.toString());

        course.getTeachingHours();




    }
}
