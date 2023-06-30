package br.com.wesleysistemas.sistemadeatas.dto.in;

import br.com.wesleysistemas.sistemadeatas.enums.Sector;
import br.com.wesleysistemas.sistemadeatas.exception.InvalidCpfThirdPartyAPIException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonDtoInDataSignUp {
    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Sector setor;

    public String getCpf() {
        if (cpf.length() != 11) {
            throw new InvalidCpfThirdPartyAPIException("O FORMATO DO CPF É INVALIDO!");
        }
        return cpf.trim();
    }
}
