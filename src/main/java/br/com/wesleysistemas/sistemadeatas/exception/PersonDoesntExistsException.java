package br.com.wesleysistemas.sistemadeatas.exception;

public class PersonDoesntExistsException extends RuntimeException {
    public PersonDoesntExistsException(Long id) {
        super("Person with ID " + id + " doesn't exists.");
    }
}
