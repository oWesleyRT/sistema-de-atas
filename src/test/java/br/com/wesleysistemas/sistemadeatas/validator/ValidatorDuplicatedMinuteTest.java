package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.exception.MinuteDuplicatedException;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidatorDuplicatedMinuteTest {

    @Autowired
    private ValidatorDuplicatedMinute validator;

    @Test
    @DisplayName("Throw duplicated minute exception.")
    public void validation(){
        Minute minute = new Minute();
        MinuteRepository minuteRepository = Mockito.mock(MinuteRepository.class);
        Mockito.when(minuteRepository.existsByTitleAndDateAndLocale(null,null,null))
                .thenReturn(true);

        Assertions.assertThrows(MinuteDuplicatedException.class,
                () -> validator.validation(minute, minuteRepository));
    }

}