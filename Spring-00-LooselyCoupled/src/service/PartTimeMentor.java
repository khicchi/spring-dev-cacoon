package service;

import com.lespania.interfaces.*;

public class PartTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("Part Time account created");
    }
}
