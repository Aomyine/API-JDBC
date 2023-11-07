package com.restapi.prog2;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.restapi.prog2.classes.Cidade;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class CidadeController {
    
	private List<Cidade> Cidades;

	public CidadeController() {
		this.Cidades = new ArrayList<>();
	}

	@GetMapping("/api/Cidades")
	Iterable<Cidade> getCidades() {
		return this.Cidades;
	}
	
	@GetMapping("/api/Cidades/{id}")
	Optional<Cidade> getCidade(@PathVariable long id) {
		for (Cidade p: Cidades) {
			if (p.getIdCidade() == id) {
				return Optional.of(p);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/Cidades")
	Cidade createCidade(@RequestBody Cidade p) {
		int maxId = 1;
		for (Cidade cid : Cidades) {
			if (cid.getIdCidade() > maxId) {
				maxId = cid.getIdCidade();
			}
		}
		p.setIdCidade(maxId+1);
		Cidades.add(p);
		return p;
	}
	
	@PutMapping("/api/Cidades/{CidadeId}")
	Optional<Cidade> updateCidade(@RequestBody Cidade CidadeRequest, @PathVariable int CidadeId) {
		Optional<Cidade> opt = this.getCidade(CidadeId);
		if (opt.isPresent()) {
			Cidade Cidade = opt.get();
			Cidade.setNomeCidade(CidadeRequest.getNomeCidade());
			Cidade.setEstado(CidadeRequest.getEstado());
			Cidade.setIdCidade(CidadeRequest.getIdCidade());
			Cidade.setPais(CidadeRequest.getPais());
			Cidade.setPopulacao(CidadeRequest.getPopulacao());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/Cidades/{id}")
	void deleteCidade(@PathVariable int id) {
		Cidades.removeIf(p -> p.getIdCidade() == id);
	}		
}

