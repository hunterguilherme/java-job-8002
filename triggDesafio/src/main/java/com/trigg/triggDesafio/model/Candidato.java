package com.trigg.triggDesafio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Getter
@Setter
public class Candidato {

    @JsonProperty("_id")
    private String id;
    private String nome;
    private String vaga;

    @JsonIgnore
    private long idade;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_nascimento;

}
