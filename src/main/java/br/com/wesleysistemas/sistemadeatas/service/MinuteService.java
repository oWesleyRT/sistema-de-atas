package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.MinuteDtoInDataRegister;
import br.com.wesleysistemas.sistemadeatas.dto.out.MinuteDtoOutDataRegister;
import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorDuplicatedMinute;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorListPeopleIfAllExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MinuteService {
    private final MinuteRepository repository;
    private final PersonRepository personRepository;
    private final ValidatorDuplicatedMinute validatorDuplicatedMinute;
    private final ValidatorListPeopleIfAllExists validatorListPeopleIfAllExists;

    @Autowired
    public MinuteService(MinuteRepository repository, PersonRepository personRepository,
                         ValidatorDuplicatedMinute validatorDuplicatedMinute, ValidatorListPeopleIfAllExists validatorListPeopleIfAllExists){
        this.repository = repository;
        this.personRepository = personRepository;
        this.validatorListPeopleIfAllExists = validatorListPeopleIfAllExists;
        this.validatorDuplicatedMinute = validatorDuplicatedMinute;

    }

    public MinuteDtoOutDataRegister register(MinuteDtoInDataRegister data){
        Minute minute = new Minute(data.title(), data.date(), data.locale(), data.schedule(),
                data.decisions(), data.responsibilities(), data.summary());
        validatorListPeopleIfAllExists.validation(data.peopleIds(), personRepository);
        validatorDuplicatedMinute.validation(minute, repository);
        minute.setPeople(new ArrayList<>());
        data.peopleIds().forEach(personId -> minute.getPeople()
                .add(personRepository.getReferenceById(personId)));
        repository.save(minute);

        return new MinuteDtoOutDataRegister(minute.getId());
    }
}
