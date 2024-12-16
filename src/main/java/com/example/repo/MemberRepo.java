package com.example.repo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Member;

import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface MemberRepo extends MongoRepository<MemberRepo, String> {
    Optional<Member> findByEmail(String email);  // To find a member by email
    Optional<Member> findByid(String id);
}

   

