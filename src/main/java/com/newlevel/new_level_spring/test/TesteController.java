package com.newlevel.new_level_spring.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    private final TesteRepository repository;

    public TesteController(TesteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/teste")
    public String teste() {
        repository.save(new Teste("PostgreSQL funcionando!"));
        return "Banco funcionando!";
    }
}