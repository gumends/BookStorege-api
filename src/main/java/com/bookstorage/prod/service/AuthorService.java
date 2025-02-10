package com.bookstorage.prod.service;

import com.bookstorage.prod.dto.AuthorDTO;
import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public AuthorModel findById(UUID id){
        return  authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public AuthorModel patchById(UUID id, AuthorDTO authorDTO){
        AuthorModel am = findById(id);
        if (authorDTO.name() != null){
            am.setName(authorDTO.name());
        }
        return authorRepository.save(am);
    }

    public void deleteById(UUID id){
        authorRepository.deleteById(id);
    }

}
