package br.com.wesleysistemas.sistemadeatas.dto.out;

import br.com.wesleysistemas.sistemadeatas.entity.Person;
import br.com.wesleysistemas.sistemadeatas.enums.Sector;
import lombok.Data;

@Data
public class PersonDtoOutDetailed {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private Sector setor;

    public PersonDtoOutDetailed(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.email = person.getEmail();
        this.setor = person.getSector();
    }
}
