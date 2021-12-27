package com.lespania;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring11Rest70OpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring11Rest70OpenApi3Application.class, args);
    }

    @Bean
    public OpenAPI myOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Cinema Application")
                        .version("v1")
                        .description("Selling online cinema tickets"));
    }
}
