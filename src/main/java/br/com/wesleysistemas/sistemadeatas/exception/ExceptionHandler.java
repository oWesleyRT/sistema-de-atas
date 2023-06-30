package br.com.wesleysistemas.sistemadeatas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> badRequest(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        var listaErros = errors.stream().map(error -> error.getField() + " " + error.getDefaultMessage()).toList();
        return ResponseEntity.badRequest().body(listaErros);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidCpfThirdPartyAPIException.class)
    public ResponseEntity<String> cpfInvalido(InvalidCpfThirdPartyAPIException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
