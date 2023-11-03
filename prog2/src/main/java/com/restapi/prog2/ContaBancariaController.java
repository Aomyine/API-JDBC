package com.restapi.prog2;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ContaBancariaController {
      
	private List<ContaBancaria> Contas;

	public ContaBancariaController() {
		this.Contas = new ArrayList<>();
	}

	@GetMapping("/api/Contas")
	Iterable<ContaBancaria> getContas() {
		return this.Contas;
	}
	
	@GetMapping("/api/Contas/{id}")
	Optional<ContaBancaria> getConta(@PathVariable long id) {
		for (ContaBancaria p: Contas) {
			if (p.getIdTitular() == id) {
				return Optional.of(p);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/Contas")
	ContaBancaria createConta(@RequestBody ContaBancaria p) {
		int maxId = 1;
		for (ContaBancaria contaTitular : Contas) {
			if (contaTitular.getIdTitular() > maxId) {
				maxId = contaTitular.getIdTitular();
			}
		}
		p.setIdTitular(maxId+1);
		Contas.add(p);
		return p;
	}
	
	@PutMapping("/api/Contas/{TitularId}")
	Optional<ContaBancaria> updateContaBancaria(@RequestBody ContaBancaria ContaRequest, @PathVariable int TitularId) {
		Optional<ContaBancaria> opt = this.getConta(TitularId);
		if (opt.isPresent()) {
			ContaBancaria Conta = opt.get();
			Conta.setNomeTitular(ContaRequest.getNomeTitular());
			Conta.setAgencia(ContaRequest.getAgencia());
			Conta.setSaldo(ContaRequest.getSaldo());
			Conta.setIdTitular(ContaRequest.getIdTitular());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/Contas/{id}")
	void deleteCidade(@PathVariable int id) {
		Contas.removeIf(p -> p.getIdTitular() == id);
	}		
}
