package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AuthorDTO;
import com.example.dto.AuthorSaveDTO;
import com.example.dto.AuthorUpdateDTO;
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
        return  author.getAuthor_name();
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for(Author author : getAuthors){
            AuthorDTO authorDTO = new AuthorDTO(
                author.getAuthor_id(),author.getAuthor_name()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {
        if(authorRepo.existsById((int) authorUpdateDTO.getAuthor_id())){
        Author author = authorRepo.getById(authorUpdateDTO.getAuthor_id());
        author.setAuthorName(authorUpdateDTO.getAuthor_name());
        authorRepo.save(author);
        return author.getAuthorName();}
        else
        {
            System.out.println("Author ID Not Exist!!!!!!!");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id)){
            authorRepo.deleteById(id);
        }else{
            System.out.println("ID Not Found");
        }
        return null;
    }
    


}
