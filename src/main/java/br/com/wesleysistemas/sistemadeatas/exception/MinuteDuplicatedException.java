package br.com.wesleysistemas.sistemadeatas.exception;

public class MinuteDuplicatedException extends RuntimeException {

    public MinuteDuplicatedException(){
        super("This minute already exists on the system.");
    }

}
