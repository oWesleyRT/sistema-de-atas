package br.com.wesleysistemas.sistemadeatas.repository;

import br.com.wesleysistemas.sistemadeatas.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
