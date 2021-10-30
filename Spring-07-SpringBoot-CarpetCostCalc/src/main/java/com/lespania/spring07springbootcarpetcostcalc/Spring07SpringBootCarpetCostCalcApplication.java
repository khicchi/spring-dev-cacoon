package com.lespania.spring07springbootcarpetcostcalc;

import com.lespania.calculator.Calculator;
import com.lespania.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.lespania")
public class Spring07SpringBootCarpetCostCalcApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext container = SpringApplication.run(Spring07SpringBootCarpetCostCalcApplication.class, args);

        Calculator calculator = container.getBean("calculator",Calculator.class);

        System.out.println(calculator.getTotalCarpetCost(City.DULLES));
    }

}
