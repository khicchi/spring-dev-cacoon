package com.lespania.configs;

import com.lespania.interfaces.ExtraSessions;
import com.lespania.services.Java;
import com.lespania.services.OfficeHours;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.lespania")
@PropertySource("classpath:application.properties")
public class MyAppClass {

    /*
    @Bean
    public Java java(){
        return new Java(extraSessions());//injection
    }

    @Bean
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }*/

}
