package br.com.wesleysistemas.sistemadeatas.dto.in;

import br.com.wesleysistemas.sistemadeatas.enums.Sector;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonDtoInUpdate {
    @NotNull
    private Long id;

    private String nome;

    private String email;

    private Sector setor;
}
