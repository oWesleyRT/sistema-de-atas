package br.com.wesleysistemas.sistemadeatas.controller;

import br.com.wesleysistemas.sistemadeatas.dto.in.PersonDtoInDataSignUp;
import br.com.wesleysistemas.sistemadeatas.dto.out.PersonDtoOutDetailedSignUp;
import br.com.wesleysistemas.sistemadeatas.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("pessoas")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PersonDtoInDataSignUp dados, UriComponentsBuilder uriBuilder) {
        PersonDtoOutDetailedSignUp pessoa = personService.signUp(dados);
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }
}
