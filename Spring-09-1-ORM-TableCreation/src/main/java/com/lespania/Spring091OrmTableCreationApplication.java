package com.lespania;

import com.lespania.entity.Car;
import com.lespania.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring091OrmTableCreationApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring091OrmTableCreationApplication.class, args);
    }

    @PostConstruct
    public void dataInit(){

        Car c1 = new Car("BMW","M5");
        Car c2 = new Car("Kia","Sorento");
        Car c3 = new Car("Mercedes","S500");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

    }
}
