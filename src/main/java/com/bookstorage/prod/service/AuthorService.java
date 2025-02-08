package com.bookstorage.prod.service;

import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorModel save(AuthorModel authorModel){
        return authorRepository.save(authorModel);
    }

    public List<AuthorModel> getAll(){
        return authorRepository.findAll();
    }
}
