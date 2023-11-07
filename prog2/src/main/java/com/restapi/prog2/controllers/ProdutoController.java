package com.restapi.prog2.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.restapi.prog2.classes.Produto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    private List<Produto> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    @GetMapping("/api/Produtos")
    Iterable<Produto> getProdutos() {
        return this.produtos;
    }

    @GetMapping("/api/Produtos/{id}")
    Optional<Produto> getProduto(@PathVariable int id) {
        return this.produtos.stream()
            .filter(p -> p.getIdProduto() == id)
            .findFirst();
    }

    @PostMapping("/api/Produtos")
    Produto createProduto(@RequestBody Produto produto) {
        int maxId = this.produtos.stream()
            .map(Produto::getIdProduto)
            .max(Integer::compare)
            .orElse(0);
        produto.setIdProduto(maxId + 1);
        this.produtos.add(produto);
        return produto;
    }

    @PutMapping("/api/Produtos/{ProdutoId}")
    Optional<Produto> updateProduto(@RequestBody Produto ProdutoRequest, @PathVariable int ProdutoId) {
        Optional<Produto> opt = getProduto(ProdutoId);
        if (opt.isPresent()) {
            Produto produto = opt.get();
            produto.setDescricao(ProdutoRequest.getDescricao());
            produto.setMarca(ProdutoRequest.getMarca());
            produto.setPreco(ProdutoRequest.getPreco());
        }

        return opt;
    }

    @DeleteMapping(value = "/api/Produtos/{id}")
    void deleteProduto(@PathVariable int id) {
        this.produtos.removeIf(p -> p.getIdProduto() == id);
    }
}
