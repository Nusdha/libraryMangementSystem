package com.example.service;

import java.util.List;

import com.example.dto.AuthorDTO;
import com.example.dto.AuthorSaveDTO;
import com.example.dto.AuthorUpdateDTO;

public interface AuthorService {

    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<AuthorDTO> getAllAuthor();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);
    
    String deleteAuthor(int id);
}
