package br.com.wesleysistemas.sistemadeatas.exception;

import br.com.wesleysistemas.sistemadeatas.interfaces.Messages;

public class InvalidCpfThirdPartyAPIException extends RuntimeException {
    public InvalidCpfThirdPartyAPIException(String msg) {
        super(msg);
    }
    public InvalidCpfThirdPartyAPIException() {
        super(Messages.INVALID_CPF);
    }

}
