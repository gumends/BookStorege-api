package com.bookstorage.prod.service;

import com.bookstorage.prod.dto.BookDTO;
import com.bookstorage.prod.infra.exceptions.LivroNaoEncontradoException;
import com.bookstorage.prod.models.AuthorModel;
import com.bookstorage.prod.models.BookModel;
import com.bookstorage.prod.repository.AuthorRepository;
import com.bookstorage.prod.repository.BookRepository;
import com.bookstorage.prod.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public BookModel save(BookDTO bookDTO){
        BookModel book = new BookModel();

        book.setTitle(bookDTO.title());
        book.setPublisher(publisherRepository.findById(bookDTO.publisherId()).orElseThrow());
        book.setAuthors(authorRepository.findAllById(bookDTO.authorsIds()));

        return bookRepository.save(book);
    }

    public List<BookModel> getAll(){
        return bookRepository.findAll();
    }

    public BookModel getBookByTitle(String title){
        return bookRepository.findByTitle(title).orElseThrow();
    }

    public BookModel getBookById(UUID id){
        return bookRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado"));
    }

    public void deleteBookById(UUID id) {
        bookRepository.deleteById(id);
    }

    public BookModel atualizarBook(UUID id, BookDTO bookDTO){

        BookModel book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (bookDTO.title() != null) {
            book.setTitle(bookDTO.title());
        }

        if (bookDTO.publisherId()!= null){
            book.setPublisher(publisherRepository.findById(bookDTO.publisherId())
                    .orElseThrow(() -> new RuntimeException("Editora não encontrada")));
        }

        if (bookDTO.authorsIds() != null && !bookDTO.authorsIds().isEmpty()){
            book.setAuthors(authorRepository.findAllById(bookDTO.authorsIds()));
        }

        return bookRepository.save(book);
    }

}
