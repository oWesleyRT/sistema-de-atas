package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInDataSignUp;
import br.com.wesleysistemas.sistemadeatas.dto.out.PersonDtoOutDetailedSignUp;
import br.com.wesleysistemas.sistemadeatas.entity.Person;
import br.com.wesleysistemas.sistemadeatas.exception.InvalidCpfThirdPartyAPIException;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CpfValidatorService cpfValidatorService;

    @Retryable(RuntimeException.class)
    public PersonDtoOutDetailedSignUp signUp(PersonDtoInDataSignUp dados) {
        if (!cpfValidatorService.validateCpf(dados.getCpf())) {
            throw new InvalidCpfThirdPartyAPIException();
        }
        Person person = new Person();
        person.setNome(dados.getNome());
        person.setCpf(dados.getCpf());
        person.setEmail(dados.getEmail());
        person.setSetor(dados.getSetor());
        personRepository.save(person);
        return new PersonDtoOutDetailedSignUp(person);
    }
}
