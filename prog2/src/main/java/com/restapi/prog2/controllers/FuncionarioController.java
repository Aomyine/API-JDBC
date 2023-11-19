package com.restapi.prog2.controllers;
import java.util.*;


import com.restapi.prog2.classes.Funcionario;
import com.restapi.prog2.repositorios.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepo funcionarioRepo;


    @GetMapping("/api/Funcionarios")
    public Iterable<Funcionario> getFuncionario() {
        return funcionarioRepo.findAll();
    }
	
	@GetMapping("/api/Funcionarios/{id}")
	Optional<Funcionario> getFuncionario(@PathVariable long id) {
		return funcionarioRepo.findById(id);
	}
	
	@PostMapping("/api/Funcionarios")
	Funcionario createFuncionario(@RequestBody Funcionario f) {
		Funcionario createdFunc = funcionarioRepo.save(f);
		return createdFunc;
	}
	
	@PutMapping("/api/Funcionarios/{id}")
	Optional<Funcionario> updateFuncionario(@RequestBody Funcionario funcionarioRequest, @PathVariable long id) {
		Optional<Funcionario> opt = funcionarioRepo.findById(id);
		if (opt.isPresent()) {
			if (funcionarioRequest.getId() == id) {
				funcionarioRepo.save(funcionarioRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do funcionário com id " + id);	
	}	
	
	@DeleteMapping(value = "/api/Funcionarios/{id}")
	void deleteFuncionario(@PathVariable long id) {
		funcionarioRepo.deleteById(id);
	}		
}
