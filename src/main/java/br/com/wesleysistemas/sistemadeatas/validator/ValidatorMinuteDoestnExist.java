package br.com.wesleysistemas.sistemadeatas.validator;

import br.com.wesleysistemas.sistemadeatas.exception.MinuteDoesntExistException;
import br.com.wesleysistemas.sistemadeatas.repository.MinuteRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidatorMinuteDoestnExist {
    public void validation(Long id, MinuteRepository minuteRepository) {
        if(!minuteRepository.existsById(id)){
            throw new MinuteDoesntExistException(id);
        }
    }
}
