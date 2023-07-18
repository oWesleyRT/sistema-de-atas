package br.com.wesleysistemas.sistemadeatas.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> badRequest(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getFieldErrors().stream().map(error -> error.getField() + " " + error.getDefaultMessage()).toList());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidCpfThirdPartyAPIException.class)
    public ResponseEntity<String> cpfInvalido(InvalidCpfThirdPartyAPIException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> notFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<String> personAlreadyExists(PersonAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
