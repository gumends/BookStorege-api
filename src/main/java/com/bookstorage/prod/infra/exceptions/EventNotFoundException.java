package com.bookstorage.prod.infra.exceptions;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(){
        super("Evento não encontrado");
    }

    public EventNotFoundException(String message) {
        super(message);
    }

}
