package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.PublisherSaveDTO;
import com.example.entity.Publisher;
import com.example.repo.PublisherRepo;
import com.example.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = new Publisher(
            publisherSaveDTO.getPublisherName()
        ) ;
        publisherRepo.save(publisher);
        return publisher.getPublisherName();
    }

    

}
