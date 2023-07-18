package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInDataSignUp;
import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInUpdate;
import br.com.wesleysistemas.sistemadeatas.dto.out.PersonDtoOutDetailed;
import br.com.wesleysistemas.sistemadeatas.entity.Person;
import br.com.wesleysistemas.sistemadeatas.exception.InvalidCpfThirdPartyAPIException;
import br.com.wesleysistemas.sistemadeatas.exception.PersonAlreadyExistsException;
import br.com.wesleysistemas.sistemadeatas.interfaces.Messages;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    CpfValidatorService cpfValidatorService;

    public PersonDtoOutDetailed signUp(PersonDtoInDataSignUp data) {
        if (personRepository.findByCpf(data.getCpf()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }
        if (!cpfValidatorService.validateCpf(data.getCpf())) {
            throw new InvalidCpfThirdPartyAPIException();
        }
        Person person = new Person();
        person.setName(data.getName().trim().replaceAll("\\.", ""));
        person.setCpf(data.getCpf().trim().replaceAll("\\.", ""));
        person.setEmail(data.getEmail().trim());
        person.setSector(data.getSector());
        personRepository.save(person);
        return new PersonDtoOutDetailed(person);
    }

    public PersonDtoOutDetailed searchPerson(String cpf) {
        Optional<Person> possiblePerson = personRepository.findByCpf(cpf);
        if (possiblePerson.isEmpty()) {
            throw new EntityNotFoundException(Messages.PERSON_NOT_FOUND);
        }
        return new PersonDtoOutDetailed(possiblePerson.get());
    }

    public PersonDtoOutDetailed update(PersonDtoInUpdate data) {
        Person person = personRepository.getReferenceById(data.getId());
        if (data.getNome() != null) {
            person.setName(data.getNome());
        }
        if (data.getEmail() != null) {
            person.setEmail(data.getEmail());
        }
        if (data.getSetor() != null) {
            person.setSector(data.getSetor());
        }
        personRepository.save(person);
        return new PersonDtoOutDetailed(person);
    }

    public Page<PersonDtoOutDetailed> listAll(Pageable pgn) {
        return personRepository.findAll(pgn).map(PersonDtoOutDetailed::new);
    }

    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException(Messages.ID_NOT_FOUND);
        }
        personRepository.deleteById(id);
    }
}
