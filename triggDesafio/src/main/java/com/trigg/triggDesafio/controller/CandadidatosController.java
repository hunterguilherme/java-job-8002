package com.trigg.triggDesafio.controller;

import com.trigg.triggDesafio.model.Geral;
import com.trigg.triggDesafio.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/candidatos")
public class CandadidatosController {

    @Autowired
    CandidatoService candidatoService;

    @GetMapping
    public Geral listarPorIdade() {
        return candidatoService.converter();
    }
}
