package services;

import interfaces.Course;

public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly hours: 17");
    }
}
