package com.lespania.services;

import com.lespania.interfaces.*;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
       return 4;
    }
}
