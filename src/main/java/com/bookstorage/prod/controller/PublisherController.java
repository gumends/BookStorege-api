package com.bookstorage.prod.controller;

import com.bookstorage.prod.dto.PublisherDTO;
import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.models.PublisherModel;
import com.bookstorage.prod.service.AuthorService;
import com.bookstorage.prod.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/save")
    public ResponseEntity<PublisherModel> save(@RequestBody PublisherModel publisherModel){
        return ResponseEntity.ok(publisherService.save(publisherModel));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PublisherModel>> all(){
        return ResponseEntity.ok(publisherService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherModel> getById(UUID id){
        return ResponseEntity.ok(publisherService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PublisherModel> patchById(UUID id, PublisherDTO publisherDTO){
        return ResponseEntity.ok(publisherService.patchById(id, publisherDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteById(UUID id){
        publisherService.deleteById(id);
    }
}
