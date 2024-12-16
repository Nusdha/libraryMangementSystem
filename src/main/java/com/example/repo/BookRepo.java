package com.example.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookRepo extends MongoRepository<Book, String> {
    // Custom query methods (if needed) can be added here.
}



