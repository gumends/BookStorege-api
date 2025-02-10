package com.bookstorage.prod.service;

import com.bookstorage.prod.dto.PublisherDTO;
import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.models.PublisherModel;
import com.bookstorage.prod.repository.BookRepository;
import com.bookstorage.prod.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherModel save(PublisherModel publisherModel){
        return publisherRepository.save(publisherModel);
    }

    public List<PublisherModel> getAll(){
        return publisherRepository.findAll();
    }

    public PublisherModel patchById(UUID id, PublisherDTO publisherDTO){
        PublisherModel pm = findById(id);
        if (publisherDTO.name() != null){
            pm.setName(publisherDTO.name());
        }
        return publisherRepository.save(pm);
    }

    public PublisherModel findById(UUID id){
        return  publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    public void deleteById(UUID id){
        publisherRepository.deleteById(id);
    }

}
