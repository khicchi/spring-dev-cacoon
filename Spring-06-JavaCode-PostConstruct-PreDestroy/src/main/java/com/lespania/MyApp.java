package com.lespania;

import com.lespania.interfaces.Course;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lespania.config.*;

public class MyApp {
    public static void main(String[] args) {
        
        ApplicationContext container = new AnnotationConfigApplicationContext(MyAppConfig.class);

        Course course = container.getBean("java", Course.class);

        course.getTeachingHours();

        ((AnnotationConfigApplicationContext)container).close();


    }
}
