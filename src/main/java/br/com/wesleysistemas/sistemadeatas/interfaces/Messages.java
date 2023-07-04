package br.com.wesleysistemas.sistemadeatas.interfaces;

public interface Messages {

    String PERSON_ALREADY_EXISTS = "Já existe uma pessoa cadastrada com esse CPF!";
    String PERSON_NOT_FOUND = "Não foi encontrado ninguem com esse CPF!";
    String ID_NOT_FOUND = "Não foi encontrado ninguem com esse id!";
    String INVALID_CPF = "CPF INVALIDO!";
    String CPF_SYNTAX_INVALID = "O FORMATO DO CPF É INVALIDO!";
    String THIRD_PARTY_SERVICE_FAILED = "Falha ao consultar o CPF no serviço externo!";
}
