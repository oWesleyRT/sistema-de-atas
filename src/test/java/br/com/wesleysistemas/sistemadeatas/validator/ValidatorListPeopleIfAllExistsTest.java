package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.exception.MinuteDuplicatedException;
import br.com.wesleysistemas.sistemadeatas.exception.PersonDoesntExistsException;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ValidatorListPeopleIfAllExistsTest {

    @Autowired
    private ValidatorListPeopleIfAllExists validator;

    @Test
    @DisplayName("Throw person doesn't exists exception.")
    public void validation(){
        List<Long> peopleIds = new ArrayList<>();
        peopleIds.add(1L);
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        Mockito.when(personRepository.existsById(Mockito.anyLong()))
                .thenReturn(false);

        Assertions.assertThrows(PersonDoesntExistsException.class,
                () -> validator.validation(peopleIds, personRepository));
    }

}