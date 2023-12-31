package br.com.wesleysistemas.sistemadeatas.entity;


import br.com.wesleysistemas.sistemadeatas.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "people")
@Entity(name = "Person")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Sector sector;
}
