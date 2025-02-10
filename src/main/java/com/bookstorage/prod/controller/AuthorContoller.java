package com.bookstorage.prod.controller;

import com.bookstorage.prod.dto.AuthorDTO;
import com.bookstorage.prod.dto.PublisherDTO;
import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.models.BookModel;
import com.bookstorage.prod.models.PublisherModel;
import com.bookstorage.prod.service.AuthorService;
import com.bookstorage.prod.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("author")
public class AuthorContoller {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<AuthorModel> save(@RequestBody AuthorModel authorModel){
        return ResponseEntity.ok(authorService.save(authorModel));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorModel>> all(){
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorModel> getById(UUID id){
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorModel> patchById(UUID id, AuthorDTO authorDTO){
        return ResponseEntity.ok(authorService.patchById(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteById(UUID id){
        authorService.deleteById(id);
    }

}
