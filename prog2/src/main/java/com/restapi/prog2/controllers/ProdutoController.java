package com.restapi.prog2.controllers;

import com.restapi.prog2.classes.Produto;
import com.restapi.prog2.repositorios.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepo produtoRepo;

      @GetMapping("/api/Produtos")
    public Iterable<Produto> getProdutos() {
        return produtoRepo.findAll();
    }

    @GetMapping("/api/Produtos/{id}")
    public Optional<Produto> getProduto(@PathVariable long id) {
        return produtoRepo.findById(id);
    }

	@PostMapping("/api/Produtos")
	Produto createProduto(@RequestBody Produto p) {
		Produto createdProd = produtoRepo.save(p);
		return createdProd;
	}

    @PutMapping("/api/Produtos/{idProduto}")
    Optional<Produto> updateProduto(@RequestBody Produto produtoReq, @PathVariable long idProduto) {
        Optional<Produto> opt = produtoRepo.findById(idProduto);
        if (opt.isPresent()) {
            Produto produtoExistente = opt.get();
            if (produtoExistente.getIdProduto() == idProduto) {
                // Atualize os campos relevantes do produtoExistente com base nos campos de produtoReq
                produtoExistente.setDescricao(produtoReq.getDescricao());
                produtoExistente.setPreco(produtoReq.getPreco());

                produtoRepo.save(produtoExistente);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do produto com id " + idProduto);
    }

	@DeleteMapping("/api/Produtos/{id}")
	void deleteProduto(@PathVariable long id) {
		produtoRepo.deleteById(id);
	}
}
