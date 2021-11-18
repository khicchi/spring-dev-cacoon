package com.lespania.enums;

public enum EDiff {

    diff1(20),
    diff2(30),
    diff3(40),
    diff4(50);

    int val;
    private EDiff(int val){
        this.val = val;
    }
}
