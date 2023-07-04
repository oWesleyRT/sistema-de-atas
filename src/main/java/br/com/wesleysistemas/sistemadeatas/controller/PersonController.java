package br.com.wesleysistemas.sistemadeatas.controller;

import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInDataSignUp;
import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInUpdate;
import br.com.wesleysistemas.sistemadeatas.dto.out.PersonDtoOutDetailed;
import br.com.wesleysistemas.sistemadeatas.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("pessoas")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity signUp(@RequestBody @Valid PersonDtoInDataSignUp data, UriComponentsBuilder uriBuilder) {
        PersonDtoOutDetailed person = personService.signUp(data);
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(person);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity search(@PathVariable String cpf) {
        PersonDtoOutDetailed person = personService.searchPerson(cpf);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping
    public ResponseEntity listAll(@PageableDefault(size = 5, sort = {"nome"}) Pageable pgn) {
        Page<PersonDtoOutDetailed> page = personService.listAll(pgn);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PersonDtoInUpdate data) {
        PersonDtoOutDetailed person = personService.update(data);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
