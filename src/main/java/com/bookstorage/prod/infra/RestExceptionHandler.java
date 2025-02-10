package com.bookstorage.prod.infra;

import com.bookstorage.prod.infra.exceptions.LivroNaoEncontradoException;  // Importando a nova exceção
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)  // Usando a nova exceção
    public ResponseEntity<String> livroNaoEncontradoHandler(LivroNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encoontrado");
    }
}
