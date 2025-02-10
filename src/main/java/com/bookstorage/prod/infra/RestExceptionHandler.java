package com.bookstorage.prod.infra;

import com.bookstorage.prod.infra.exceptions.EventNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> eventNotFoundHandler(EventNotFoundException exception, HttpServletRequest request) {
        // Se a requisição for do Swagger, não capturar a exceção
        if (request.getRequestURI().contains("/v3/api-docs") || request.getRequestURI().contains("/swagger")) {
            throw exception;
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado!!!!!");
    }
}
