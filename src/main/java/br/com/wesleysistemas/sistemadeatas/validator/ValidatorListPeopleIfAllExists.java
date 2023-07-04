package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.exception.PersonDoesntExistsException;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidatorListPeopleIfAllExists implements Validator {
    public void validation(List<Long> peopleIds, PersonRepository personRepository) {
        for(Long id : peopleIds){
            if(!personRepository.existsById(id)){
                throw new PersonDoesntExistsException(id);
            }
        }
    }
}
