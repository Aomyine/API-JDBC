package com.restapi.prog2.controllers;
import java.util.*;

import com.restapi.prog2.classes.Cidade;
import com.restapi.prog2.classes.ContaBancaria;
import com.restapi.prog2.classes.Funcionario;
import com.restapi.prog2.classes.FuncionarioDTO;
import com.restapi.prog2.classes.Produto;
import com.restapi.prog2.repositorios.CidadeRepo;
import com.restapi.prog2.repositorios.ContaBancariaRepo;
import com.restapi.prog2.repositorios.ProdutoRepo;
import com.restapi.prog2.repositorios.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepo funcionarioRepo;
	@Autowired
	private ContaBancariaRepo contaBancariaRepo;
	@Autowired
	private ProdutoRepo produtoRepo;
	@Autowired
	private CidadeRepo cidadeRepo;
	

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
	Optional<Funcionario> updateFuncionario(@RequestBody FuncionarioDTO funcionarioRequest, @PathVariable long id) {
		Optional<Funcionario> opt = funcionarioRepo.findById(id);
		if (opt.isPresent()) {
				Funcionario existingFuncionario = opt.get();
				existingFuncionario.setNome(funcionarioRequest.getNome());
				existingFuncionario.setCargo(funcionarioRequest.getCargo());
				existingFuncionario.setSalario(funcionarioRequest.getSalario());

				Optional<ContaBancaria> optcb = contaBancariaRepo.findById(funcionarioRequest.getContaId());
				Optional<Cidade> optc = cidadeRepo.findById(funcionarioRequest.getCidadeId());
				Optional<Produto> optp = produtoRepo.findById(funcionarioRequest.getProdutoId());
				existingFuncionario.setCidade(optc.get());
				existingFuncionario.setProduto(optp.get());
				existingFuncionario.setConta(optcb.get());
				
				funcionarioRepo.save(existingFuncionario);
				return opt;
			}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do funcionário com id " + id);	
	}	
	
	@DeleteMapping(value = "/api/Funcionarios/{id}")
	void deleteFuncionario(@PathVariable long id) {
		funcionarioRepo.deleteById(id);
	}		
}
