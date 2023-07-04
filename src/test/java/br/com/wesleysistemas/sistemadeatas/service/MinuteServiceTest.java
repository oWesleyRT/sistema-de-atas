package br.com.wesleysistemas.sistemadeatas.service;

import br.com.wesleysistemas.sistemadeatas.dto.in.MinuteDtoInDataRegister;
import br.com.wesleysistemas.sistemadeatas.dto.out.MinuteDtoOutDataRegister;
import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import br.com.wesleysistemas.sistemadeatas.repository.PersonRepository;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorDuplicatedMinute;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorListPeopleIfAllExists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

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
    @DisplayName("Return a MinuteDtoIn and need save Minute on BD")
    public void register() {
        MinuteService service = new MinuteService(minuteRepository, personRepository, validatorDuplicatedMinute,
                validatorListPeopleIfAllExists);
        MinuteDtoInDataRegister minuteDtoIn = createMinuteDtoIn();
        Mockito.when(personRepository.existsById(Mockito.anyLong()))
                        .thenReturn(true);
        //Mockito.when(minuteRepository.existsByTitleAndDateAndLocale(Mockito.any(), Mockito.any(), Mockito.any()))
        //        .thenReturn(false);
        MinuteDtoOutDataRegister minuteDtoOut = service.register(minuteDtoIn);

        Assertions.assertInstanceOf(MinuteDtoOutDataRegister.class, minuteDtoOut);
        Mockito.verify(minuteRepository).save(Mockito.any(Minute.class));
    }

    public MinuteDtoInDataRegister createMinuteDtoIn(){
        List<Long> peopleIds = new ArrayList<>();
        peopleIds.add(1L);
        return new MinuteDtoInDataRegister("teste", LocalDateTime.now(),
                "teste", peopleIds, "teste", "teste", "teste",
                "teste");
    }
}