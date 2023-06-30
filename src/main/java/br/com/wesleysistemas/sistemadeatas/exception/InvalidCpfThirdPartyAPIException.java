package br.com.wesleysistemas.sistemadeatas.exception;

public class InvalidCpfThirdPartyAPIException extends RuntimeException {
    public InvalidCpfThirdPartyAPIException(String msg) {
        super(msg);
    }
    public InvalidCpfThirdPartyAPIException() {
        super("CPF INVALIDO!");
    }

}
