package com.workshop_mongo.demo.service;

import com.workshop_mongo.demo.domain.Post;
import com.workshop_mongo.demo.domain.User;
import com.workshop_mongo.demo.dto.UserDTO;
import com.workshop_mongo.demo.repository.PostRepository;
import com.workshop_mongo.demo.repository.UserRepository;
import com.workshop_mongo.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    // a seguir retorna os post por id
    public Post findById(String id){
       Optional<Post> obj = postRepository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Post nao encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
    public List<Post> fullSearch(String text , Date minDate , Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60*60*1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }

}
