package com.bookstorage.prod.repository;

import com.bookstorage.prod.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

}
