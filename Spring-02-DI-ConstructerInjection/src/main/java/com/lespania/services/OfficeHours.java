package com.lespania.services;


import com.lespania.interfaces.*;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
       return 5;
    }
}
