package com.bookstorage.prod.repository;

import com.bookstorage.prod.models.ReviewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<ReviewsModel, UUID> {
}
