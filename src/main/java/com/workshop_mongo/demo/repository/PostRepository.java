package com.workshop_mongo.demo.repository;

import com.workshop_mongo.demo.domain.Post;
import com.workshop_mongo.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

     //void deleteById(String id);
}
