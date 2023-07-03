package br.com.wesleysistemas.sistemadeatas.repository;

import br.com.wesleysistemas.sistemadeatas.entity.Minute;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface MinuteRepository extends CrudRepository<Minute, Long> {
    public boolean existsByTitleAndDateAndLocale(String title, Date date, String locale);
}
