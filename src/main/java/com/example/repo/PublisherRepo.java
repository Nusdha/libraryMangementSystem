package com.example.repo;


import java.util.concurrent.Flow.Publisher;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepo extends MongoRepository<Publisher,Integer>{

    void save(com.example.entity.Publisher publisher);

}
