package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AuthorSaveDTO;
import com.example.entity.Author;
import com.example.repo.AuthorRepo;
import com.example.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(authorSaveDTO.getAuthor_name());
        authorRepo.save(author);
        return null;
    }


}
