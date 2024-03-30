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
       Optional<User> obj = repo.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
       repo.deleteById(id);
    }

    public User upDate(User obj){
        User newObj = findById(obj.getId());
        upDateData(newObj,obj);
        return repo.save(newObj);
    }

    private void upDateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }


}
