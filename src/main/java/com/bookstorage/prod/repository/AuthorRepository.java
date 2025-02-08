package com.bookstorage.prod.repository;

import com.bookstorage.prod.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
