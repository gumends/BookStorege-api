package com.bookstorage.prod.dto;

import java.util.Set;
import java.util.UUID;

public record BookDTO(
        String title,
        UUID id,
        Set<UUID>
) {
}
