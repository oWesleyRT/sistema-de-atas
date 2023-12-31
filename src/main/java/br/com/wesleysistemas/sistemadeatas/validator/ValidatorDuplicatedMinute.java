package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import br.com.wesleysistemas.sistemadeatas.exception.MinuteDuplicatedException;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidatorDuplicatedMinute {
    public void validation(Minute minute, MinuteRepository minuteRepository) {
        if(minuteRepository.existsByTitleAndDateAndLocale(minute.getTitle(), minute.getDate(), minute.getLocale())){
            throw new MinuteDuplicatedException();
        }
    }
}
