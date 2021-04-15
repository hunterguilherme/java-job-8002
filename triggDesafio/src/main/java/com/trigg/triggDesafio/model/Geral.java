package com.trigg.triggDesafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
public class Geral {
    private String recrutador;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dtAberturaVaga;

    List<Candidato> candidatos;
}
