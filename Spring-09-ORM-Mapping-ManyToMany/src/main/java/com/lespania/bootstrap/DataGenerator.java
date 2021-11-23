package com.lespania.bootstrap;

import com.lespania.entity.Post;
import com.lespania.entity.Tag;
import com.lespania.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("ORM","ManyToMany");
        Post post1 = new Post("MVC","Controller");

        Tag tag0 = new Tag("Springboot");
        Tag tag1 = new Tag("JPA");

        post.getTags().add(tag0);
        post.getTags().add(tag1);

        postRepository.save(post);
        postRepository.save(post1);


        //        tag0.getPosts().add(post);
//        tag1.getPosts().add(post);
//
//        tag0.getPosts().add(post1);
//        post1.getTags().add(tag0);
    }
}
