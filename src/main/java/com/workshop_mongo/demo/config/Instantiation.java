package com.workshop_mongo.demo.config;

import com.workshop_mongo.demo.domain.Post;
import com.workshop_mongo.demo.domain.User;
import com.workshop_mongo.demo.repository.PostRepository;
import com.workshop_mongo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static java.util.Arrays.*;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.getTimeZone();

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem", "Vou viajar para sao paulo" , maria );
        Post post2 = new Post(null , sdf.parse("23/03/2018"),"Bom Dia","Acordei Faliz Hoje",maria );

        userRepository.saveAll(asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
