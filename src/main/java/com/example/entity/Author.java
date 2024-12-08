package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autor")
public class Author {

    @Id
    private long author_id;
    private String author_name;
    
    public long getAutorId(){
        return author_id;
    }

    public void setAuthorId(long author_id){
        this.author_id =author_id;
    }

    public String getAuthorName(){
        return author_name;
    }

    public void setAuthorName(String author_name){
        this.author_name = author_name;
    }
}
