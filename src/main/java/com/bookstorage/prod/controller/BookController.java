package com.bookstorage.prod.controller;

import com.bookstorage.prod.models.BookModel;
import com.bookstorage.prod.service.BookService;
import com.bookstorage.prod.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/save")
    public ResponseEntity<BookModel> save(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.save(bookDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookModel>> all(){
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getOne(@PathVariable("id") UUID id){
        return ResponseEntity.ok(bookService.getOne(id));
    }
}
