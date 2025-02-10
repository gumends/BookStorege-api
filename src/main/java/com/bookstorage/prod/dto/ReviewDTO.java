package com.bookstorage.prod.dto;

import com.bookstorage.prod.models.BookModel;

import java.util.UUID;

public record ReviewDTO(
        String name,
        UUID bookId
) {
}
