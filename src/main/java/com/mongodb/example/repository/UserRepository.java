package com.mongodb.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.example.document.User;

public interface UserRepository extends MongoRepository<User, Integer> {

}
