package com.lespania;

public interface DataRepository {
    int[] findAll();
    int[] findById(int id);
}
