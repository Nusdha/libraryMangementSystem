package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthorSaveDTO;
import com.example.service.AuthorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        String authorname = authorService.addAuthor(authorSaveDTO);
        return authorname;
    }

}
