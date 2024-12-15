package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "publiser")
@Data

public class publisher {
    @Id
    private long publiserId;
    private String publiserName;

    public void Publiser(int publiserId,String publiserName){
        this.publiserId = publiserId;
        this.publiserName = publiserName;
    }

    public void Publiser(String publiserName){
        this.publiserName = publiserName;
    }

    public long getPubliserId(){
        return publiserId;
    }

    public void setPubliserId(long publiserId){
        this.publiserId =publiserId;
    }

    public String getAuthorName(){
        return publiserName;
    }

    public void setAuthorName(String publiserName){
        this.publiserName = publiserName;
    }

    @Override
    public String toString(){
            return "Publiser{"+ "Publiser ID : " + publiserId +", Publiser Name :" + publiserName + '\'' + '}';
    }
}
