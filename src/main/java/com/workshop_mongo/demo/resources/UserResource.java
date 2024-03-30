package com.workshop_mongo.demo.resources;

import com.workshop_mongo.demo.domain.User;
import com.workshop_mongo.demo.dto.UserDTO;
import com.workshop_mongo.demo.service.UserService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource  {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
