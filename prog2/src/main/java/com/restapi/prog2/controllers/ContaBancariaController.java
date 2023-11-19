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
    public Iterable<ContaBancaria> getContaBancaria() {
        return contaBancariaRepo.findAll();
    }

    @GetMapping("/api/Contas/{id}")
    public Optional<ContaBancaria> getContaBancaria (@PathVariable long id) {
        return contaBancariaRepo.findById(id);
    }

	@PostMapping("/api/Contas")
	ContaBancaria createContaBancaria(@RequestBody ContaBancaria c) {
		ContaBancaria createdCon = contaBancariaRepo.save(c);
		return createdCon;
	}

    @PutMapping("/api/Contas/{idTitular}")
	Optional<ContaBancaria> updateContaBancaria(@RequestBody ContaBancaria contaReq, @PathVariable long idTitular) {
		Optional<ContaBancaria> opt = contaBancariaRepo.findById(idTitular);
		if (opt.isPresent()) {
			if (contaReq.getIdTitular() == idTitular) {
				contaBancariaRepo.save(contaReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da conta com id " + idTitular);
	}	

	@DeleteMapping("/api/Contas/{id}")
	void deleteConta(@PathVariable long id) {
		contaBancariaRepo.deleteById(id);
    }
}
