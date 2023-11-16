package com.restapi.prog2.controllers;
import com.restapi.prog2.classes.Cidade;
import com.restapi.prog2.repositorios.CidadeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping
public class CidadeController {

    @Autowired
    private CidadeRepo cidadeRepo;

    @GetMapping("/api/Cidades")
    public Iterable<Cidade> getCidades() {
        return cidadeRepo.findAll();
    }

    @GetMapping("/api/Cidades/{id}")
    public Optional<Cidade> getCidade(@PathVariable int id) {
        return cidadeRepo.findById(id);
    }

    @PostMapping("/api/Cidades")
    public ResponseEntity<Cidade> createCidade(@RequestBody Cidade cidade) {
        Cidade createdCidade = cidadeRepo.save(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCidade);
    }


    @PutMapping("/api/Cidades/{cidadeId}")
    public int updateCidade(@RequestBody Cidade cidadeRequest, @PathVariable int cidadeId) {
        Optional<Cidade> opt = cidadeRepo.findById(cidadeId);
        if (opt.isPresent()) {
            if (cidadeRequest.getIdCidade() == cidadeId) {
                cidadeRepo.save(cidadeRequest);
                return cidadeId;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da cidade com id " + cidadeId);
    }

    @DeleteMapping("/api/Cidades/{id}")
    public void deleteCidade(@PathVariable int id) {
        cidadeRepo.deleteById(id);
    }
}