package service;

import com.lespania.interfaces.*;

public class FullTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("Full Time account created");
    }
}
