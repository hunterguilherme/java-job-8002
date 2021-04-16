package com.trigg.triggDesafio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trigg.triggDesafio.model.Candidato;
import com.trigg.triggDesafio.model.Geral;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class CandidatoService {


    public Geral converter() {
        LocalDateTime hoje = LocalDateTime.now();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        Geral geral = null;

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("src\\main\\resources\\static\\candidatos.json"));

            ObjectMapper objectMapper = new ObjectMapper();

            geral = objectMapper.convertValue(jsonObject, Geral.class);
            List<Candidato> candidatos = geral.getCandidatos();

            calculoIdade(hoje, candidatos);

            //Bubble sort
            Ordenar(candidatos);

        }
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return geral;
    }

    private void Ordenar(List<Candidato> candidatos) {
        boolean moved;
        do {
            moved = false;
            for (int i = 1; i < candidatos.size(); i++) {
                if (candidatos.get(i-1).getIdade() > candidatos.get(i).getIdade()) {
                    Collections.swap(candidatos, i - 1, i);
                    moved = true;
                }
            }

        } while (moved);
    }

    private void calculoIdade(LocalDateTime hoje, List<Candidato> candidatos) {

        candidatos.forEach(candidato -> {
            LocalDate dataNascimentoConvertida = candidato.getData_nascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long idade = ChronoUnit.YEARS.between(dataNascimentoConvertida, hoje);
            candidato.setIdade(idade);
        });
    }

}
