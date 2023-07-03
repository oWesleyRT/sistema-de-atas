package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.exception.PersonDoesntExistsException;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;

import java.util.List;

public class ValidatorListPeopleIfAllExists implements Validator {
    public void validation(List<Long> data, PersonRepository personRepository) {
        for(Long id : data){
            if(!personRepository.existsById(id)){
                throw new PersonDoesntExistsException(id);
            }
        }
    }
}
