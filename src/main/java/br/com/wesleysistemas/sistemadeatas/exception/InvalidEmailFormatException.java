package br.com.wesleysistemas.sistemadeatas.exception;

public class InvalidEmailFormatException extends RuntimeException {
    public InvalidEmailFormatException() {
        super("Deve ser um endereço de e-mail bem formado");
    }
}
