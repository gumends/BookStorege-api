package com.bookstorage.prod.service;

import com.bookstorage.prod.models.BookModel;
import com.bookstorage.prod.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookModel save(BookDTO bookDTO){
        return bookRepository.save(bookDTO);
    }

    public List<BookModel> getAll(){
        return bookRepository.findAll();
    }

    public BookModel getOne(UUID id){
        return bookRepository.findById(id).orElseThrow();
    }



}
