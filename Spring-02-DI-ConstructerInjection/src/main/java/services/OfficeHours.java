package services;


import interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
       return 5;
    }
}
