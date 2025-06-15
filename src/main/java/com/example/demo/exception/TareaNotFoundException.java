package com.example.demo.exception;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(Long id) {
        super("No se encontró la tarea con id " + id);
    }
}
