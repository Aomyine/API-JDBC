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
    public Optional<Produto> getProduto(@PathVariable int id) {
        return produtoRepo.findById(id);
    }

    @PostMapping("/api/Produtos")
    public Produto createProduto(@RequestBody Produto produto) {
        try {
            Produto createdProduto = produtoRepo.save(produto);
            return createdProduto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar o produto.", e);
        }
    }

    @PutMapping("/api/Produtos/{ProdutoId}")
    public Produto updateProduto(@RequestBody Produto produtoRequest, @PathVariable int ProdutoId) {
        Optional<Produto> opt = produtoRepo.findById(ProdutoId);
        if (opt.isPresent()) {
            if (produtoRequest.getIdProduto() == ProdutoId) {
                try {
                    Produto updatedProduto = produtoRepo.save(produtoRequest);
                    return updatedProduto;
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar o produto.", e);
                }
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id " + ProdutoId);
    }

    @DeleteMapping("/api/Produtos/{id}")
    public void deleteProduto(@PathVariable int id) {
        produtoRepo.deleteById(id);
    }
}
