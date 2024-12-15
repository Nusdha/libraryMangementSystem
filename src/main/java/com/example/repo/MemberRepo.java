package com.example.repo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

@Repository
public interface MemberRepo extends MongoRepository<MemberRepo, String> {
    Optional<Member> findByEmail(String email);  // To find a member by email
    Optional<Member> findByid(String id);
}



