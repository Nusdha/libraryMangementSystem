package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Author;

public interface AuthorRepo extends MongoRepository<Author,Integer>{

}


