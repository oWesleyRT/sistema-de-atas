package br.com.wesleysistemas.sistemadeatas.dto.out;

import java.time.LocalDateTime;
import java.util.List;

public record MinuteDtoOutGetSpecificMinute(Long id,
        String title,
        LocalDateTime date,
        String locale,
        List<String> peopleName,
        String schedule,
        String decisions,
        String responsibilities,
        String summary) {
}
