package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "publisher")
@Data

public class Publisher {
    @Id
    private long publisherId;
    private String publisherName;

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString(){
            return "Publisher{"+ "Publishher ID : " + publisherId +", Publisher Name :" + publisherName + '\'' + '}';
    }
}
