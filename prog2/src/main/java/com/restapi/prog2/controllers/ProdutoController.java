package com.restapi.prog2.controllers;
import java.util.*;
import com.restapi.prog2.classes.Produto;
import com.restapi.prog2.repositorios.ProdutoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepo produtoRepo;

    @GetMapping("/api/Produtos")
    public Iterable<Produto> getProdutos() {
        return produtoRepo.findAll();
    }

    @GetMapping("/api/Produtos/{id}")
    public Optional<Produto> getProduto(@PathVariable int id) {
        return produtoRepo.findById(id);
    }

    @PostMapping("/api/Produtos")
    public Produto createProduto(@RequestBody Produto produto) {
        Produto createdProduto = produtoRepo.save(produto);
        return createdProduto;
    }

    @PutMapping("/api/Produtos/{ProdutoId}")
    public int updateProduto(@RequestBody Produto produtoRequest, @PathVariable int ProdutoId) {
        Optional<Produto> opt = produtoRepo.findById(ProdutoId);
        if (opt.isPresent()) {
            if (produtoRequest.getIdProduto() == ProdutoId) {
                produtoRepo.save(produtoRequest);
                return ProdutoId;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do produto com id " + ProdutoId);
    }

    @DeleteMapping("/api/Produtos/{id}")
    public void deleteProduto(@PathVariable int id) {
        produtoRepo.deleteById(id);
    }
}