package br.com.wesleysistemas.sistemadeatas.repository;

import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MinuteRepository extends CrudRepository<Minute, Long> {
    public boolean existsByTitleAndDateAndLocale(String title, LocalDateTime date, String locale);
}
