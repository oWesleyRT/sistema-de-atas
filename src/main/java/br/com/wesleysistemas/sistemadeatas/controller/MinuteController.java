package br.com.wesleysistemas.sistemadeatas.controller;

import br.com.wesleysistemas.sistemadeatas.dto.in.MinuteDtoInDataRegister;
import br.com.wesleysistemas.sistemadeatas.dto.out.MinuteDtoOutDataRegister;
import br.com.wesleysistemas.sistemadeatas.service.MinuteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/minutes")
public class MinuteController {
    @Autowired
    private MinuteService service;
    @PostMapping
    public ResponseEntity<MinuteDtoOutDataRegister> register(@RequestBody @Valid MinuteDtoInDataRegister data,
                                                            UriComponentsBuilder uriBuilder){
        MinuteDtoOutDataRegister dtoOut = service.register(data);
        var uri = uriBuilder.path("/minutes/v1/{id}").buildAndExpand(dtoOut.id()).toUri();

        return ResponseEntity.created(uri).body(dtoOut);
    }

}
