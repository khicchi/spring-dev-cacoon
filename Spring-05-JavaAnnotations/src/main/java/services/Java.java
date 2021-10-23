package services;

import interfaces.Course;

public class Java implements Course {


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly hours: 23");
    }
}
