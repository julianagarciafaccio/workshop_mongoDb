package com.workshop_mongo.demo.service;

import com.workshop_mongo.demo.domain.User;
import com.workshop_mongo.demo.dto.UserDTO;
import com.workshop_mongo.demo.repository.UserRepository;
import com.workshop_mongo.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
        return repo.findAll();
    }
    public User findById(String id){
        User user = findById(id);
        if (user == null){
            throw new ObjectNotFoundException("ID NAO ENCONTRADO");
        }
        return user;
    }
    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }

}
