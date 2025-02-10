package com.bookstorage.prod.controller;

import com.bookstorage.prod.dto.BookDTO;
import com.bookstorage.prod.models.BookModel;
import com.bookstorage.prod.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<BookModel> save(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.save(bookDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookModel>> all(){
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookModel>> getBookByTitle(@PathVariable String title){
        return ResponseEntity.ok(Collections.singletonList(bookService.getBookByTitle(title)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> findbyId(@PathVariable UUID id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable UUID id){
        bookService.deleteBookById(id);
    }

    @PatchMapping("/{id}")
    public BookModel patchBook(@PathVariable UUID id, @RequestBody BookDTO bookDTO){
        return bookService.atualizarBook(id, bookDTO);
    }
}
