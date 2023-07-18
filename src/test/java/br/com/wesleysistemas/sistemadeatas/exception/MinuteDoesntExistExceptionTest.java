package br.com.wesleysistemas.sistemadeatas.exception;

import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import br.com.wesleysistemas.sistemadeatas.validator.ValidatorMinuteDoestnExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MinuteDoesntExistExceptionTest {

    @Autowired
    private ValidatorMinuteDoestnExist validator;

    @Mock
    private MinuteRepository minuteRepository;

    @Test
    @DisplayName("Throw minute doesn't exist exception")
    public void validation(){
        Mockito.when(minuteRepository.existsById(Mockito.anyLong())).thenReturn(false);

        Assertions.assertThrows(MinuteDoesntExistException.class,
                () -> validator.validation(Mockito.anyLong(), minuteRepository));
    }

}