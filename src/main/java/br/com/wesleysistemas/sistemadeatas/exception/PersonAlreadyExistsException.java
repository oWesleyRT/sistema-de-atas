package br.com.wesleysistemas.sistemadeatas.exception;

import br.com.wesleysistemas.sistemadeatas.interfaces.Messages;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException() {
        super(Messages.PERSON_ALREADY_EXISTS);
    }
}
