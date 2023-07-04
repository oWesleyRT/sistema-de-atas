package br.com.wesleysistemas.sistemadeatas.dto.in;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record MinuteDtoInDataRegister(
        @NotBlank
        String title,
        @NotBlank
        LocalDateTime date,
        @NotBlank
        String locale,
        @NotBlank
        List<Long> peopleIds,
        @NotBlank
        String schedule,
        @NotBlank
        String decisions,
        @NotBlank
        String responsibilities,
        @NotBlank
        String summary
) {
}
