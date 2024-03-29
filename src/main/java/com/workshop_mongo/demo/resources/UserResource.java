package com.workshop_mongo.demo.resources;

import com.workshop_mongo.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {
    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        User juliana = new User(null , "Juliana Garcia Faccio" , "julianafaccio9@gmail.com");
        User maria = new User(null , "Maria Silvia" , "mariasilvia@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(juliana , maria));
        return ResponseEntity.ok().body(list);
    }


}
