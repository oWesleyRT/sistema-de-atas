package br.com.wesleysistemas.sistemadeatas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Minute")
@Table(name = "minutes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Minute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime date;
    private String locale;
    @ManyToMany
    @JoinColumn(name = "people_id")
    private List<Person> people;
    private String schedule;
    private String decisions;
    private String responsibilities;
    private String summary;

    public Minute(String title, LocalDateTime date, String locale,
                  String schedule, String decisions, String responsibilities, String summary){
        this.title = title;
        this.date = date;
        this.locale = locale;
        this.schedule = schedule;
        this.decisions = decisions;
        this.responsibilities = responsibilities;
        this.summary = summary;
    }
}
