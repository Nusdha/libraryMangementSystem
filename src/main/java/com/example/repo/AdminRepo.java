package com.example.repo;

import com.example.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface AdminRepo extends MongoRepository<Admin, String> {

}
