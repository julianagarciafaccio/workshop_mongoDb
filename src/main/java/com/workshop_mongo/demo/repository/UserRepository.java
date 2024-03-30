package com.workshop_mongo.demo.repository;

import com.workshop_mongo.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

     void deleteById(String id);
}
