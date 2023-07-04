package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.MinuteDtoInDataRegister;
import br.com.wesleysistemas.sistemadeatas.dto.out.MinuteDtoOutDataRegister;
import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorDuplicatedMinute;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorListPeopleIfAllExists;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MinuteServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private MinuteRepository minuteRepository;
    @Mock
    private ValidatorListPeopleIfAllExists validatorListPeopleIfAllExists;
    @Mock
    private ValidatorDuplicatedMinute validatorDuplicatedMinute;

    @Test
    public void register() {
        MinuteService service = new MinuteService(minuteRepository, personRepository, validatorDuplicatedMinute,
                validatorListPeopleIfAllExists);
        MinuteDtoInDataRegister minuteDtoIn = createMinuteDtoIn();
        var validatorListPeopleIfAllExists = Mockito.mock(ValidatorListPeopleIfAllExists.class);
        Mockito.when(personRepository.existsById(Mockito.anyLong()))
                        .thenReturn(true);
        Mockito.when(minuteRepository.existsByTitleAndDateAndLocale(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(false);
        MinuteDtoOutDataRegister minuteDtoOut = service.register(minuteDtoIn);

        Assert.isInstanceOf(MinuteDtoOutDataRegister.class, minuteDtoOut);
    }

    public MinuteDtoInDataRegister createMinuteDtoIn(){
        List<Long> peopleIds = new ArrayList<>();
        peopleIds.add(1L);
        return new MinuteDtoInDataRegister("teste", LocalDateTime.now(),
                "teste", peopleIds, "teste", "teste", "teste",
                "teste");
    }
}