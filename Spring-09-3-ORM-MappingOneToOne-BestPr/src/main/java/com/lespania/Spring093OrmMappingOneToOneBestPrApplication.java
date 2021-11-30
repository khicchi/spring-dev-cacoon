package com.lespania;

import com.lespania.entity.Post;
import com.lespania.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring093OrmMappingOneToOneBestPrApplication {

    @Autowired
    PostRepository postRepository;



    public static void main(String[] args) {

        SpringApplication.run(Spring093OrmMappingOneToOneBestPrApplication.class, args);
    }


    @PostConstruct
    public void addSomeData(){
        //postRepository.save(new Post("posttştlee1", "bykicchi"));


    }
}
