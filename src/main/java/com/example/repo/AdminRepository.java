package com.example.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Document(collection = "author")
@Data
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);

    void deleteById(Long id);

    Optional<Admin> findById(Long id);
}
