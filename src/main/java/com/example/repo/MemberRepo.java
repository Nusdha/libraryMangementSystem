package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Author;
public interface MemberRepo extends MongoRepository<Author,Integer>{

}
