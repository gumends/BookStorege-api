package com.bookstorage.prod.dto;

import java.util.Set;
import java.util.UUID;

public record BookDTO(
        String title,
        UUID publisherId,
        Set<UUID> authorsIds,
        String reviewComment
) {
}
