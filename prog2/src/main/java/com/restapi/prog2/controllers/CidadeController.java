package com.restapi.prog2.controllers;
import com.restapi.prog2.classes.Cidade;
import com.restapi.prog2.repositorios.CidadeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Optional<Cidade> getCidade(@PathVariable long id) {
        return cidadeRepo.findById(id);
    }

	@PostMapping("/api/Cidades")
	Cidade createCidade(@RequestBody Cidade c) {
		Cidade createdCid = cidadeRepo.save(c);
		return createdCid;
	}

    @PutMapping("/api/Cidades/{idCidade}")
	Optional<Cidade> updateCidade(@RequestBody Cidade cidadeReq, @PathVariable long idCidade) {
		Optional<Cidade> opt = cidadeRepo.findById(idCidade);
		if (opt.isPresent()) {
			if (cidadeReq.getIdCidade() == idCidade) {
				cidadeRepo.save(cidadeReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da cidade com id " + idCidade);
	}	

	@DeleteMapping("/api/Cidades/{id}")
	void deleteCidade(@PathVariable long id) {
		cidadeRepo.deleteById(id);
	}
}
