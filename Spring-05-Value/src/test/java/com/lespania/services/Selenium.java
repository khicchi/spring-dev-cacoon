package com.lespania.services;

import com.lespania.interfaces.*;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 23");
    }
}
