package services;

import interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly hours: 23");
    }
}
