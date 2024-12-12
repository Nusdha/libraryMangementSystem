package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Document(collection = "author")
@Data

public class Author {

    @Id
    private long author_id;
    private String author_name;

    public Author(int author_id,String author_name){
        this.author_id = author_id;
        this.author_name = author_name;
    }

    public Author(String author_name){ 
        this.author_name = author_name;
    }
    
    public long getAuthorId(){
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

    @Override
    public String toString(){
            return "Author{"+ "Author ID : " + author_id +", Author Name :" + author_name + '\'' + '}';
    }
}
