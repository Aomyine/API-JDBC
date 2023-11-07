package com.restapi.prog2.controllers;
import java.util.*;
import com.restapi.prog2.classes.ContaBancaria;
import com.restapi.prog2.repositorios.ContaBancariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ContaBancariaController {

    @Autowired
    private ContaBancariaRepo contaBancariaRepo;

    @GetMapping("/api/Contas")
    public Iterable<ContaBancaria> getContas() {
        return contaBancariaRepo.findAll();
    }

    @GetMapping("/api/Contas/{id}")
    public Optional<ContaBancaria> getConta(@PathVariable int id) {
        return contaBancariaRepo.findById(id);
    }

    @PostMapping("/api/Contas")
    public ContaBancaria createConta(@RequestBody ContaBancaria contaBancaria) {
        ContaBancaria createdConta = contaBancariaRepo.save(contaBancaria);
        return createdConta;
    }

    @PutMapping("/api/Contas/{TitularId}")
    public int updateContaBancaria(@RequestBody ContaBancaria contaRequest, @PathVariable int TitularId) {
        Optional<ContaBancaria> opt = contaBancariaRepo.findById(TitularId);
        if (opt.isPresent()) {
            if (contaRequest.getIdTitular() == TitularId) {
                contaBancariaRepo.save(contaRequest);
                return TitularId;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da conta com id " + TitularId);
    }

    @DeleteMapping("/api/Contas/{id}")
    public void deleteConta(@PathVariable int id) {
        contaBancariaRepo.deleteById(id);
    }
}