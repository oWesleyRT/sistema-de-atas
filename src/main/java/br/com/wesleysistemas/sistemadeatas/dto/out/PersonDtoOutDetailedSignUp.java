package br.com.wesleysistemas.sistemadeatas.dto.out;

import br.com.wesleysistemas.sistemadeatas.entity.Person;
import br.com.wesleysistemas.sistemadeatas.enums.Sector;
import lombok.Data;

@Data
public class PersonDtoOutDetailedSignUp {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Sector setor;

    public PersonDtoOutDetailedSignUp(Person person) {
        this.id = person.getId();
        this.nome = person.getNome();
        this.cpf = person.getCpf();
        this.email = person.getEmail();
        this.setor = person.getSetor();
    }
}
