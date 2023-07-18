package br.com.wesleysistemas.sistemadeatas.exception;

public class MinuteDoesntExistException extends RuntimeException {
    public MinuteDoesntExistException(Long id) {
        super("Minute with id " + id + " doesn't exist.");
    }
}
