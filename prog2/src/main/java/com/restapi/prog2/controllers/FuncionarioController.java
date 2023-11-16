package com.restapi.prog2.controllers;
import java.util.*;

import com.restapi.prog2.classes.Cidade;
import com.restapi.prog2.classes.ContaBancaria;
import com.restapi.prog2.classes.Produto;
import com.restapi.prog2.classes.Funcionario;
import com.restapi.prog2.repositorios.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepo funcionarioRepo;

    @GetMapping("/api/Funcionarios")
    public Iterable<Funcionario> getFuncionarios() {
        return funcionarioRepo.findAll();
    }

    @GetMapping("/api/Funcionarios/{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable int id) {
        Optional<Funcionario> opt = funcionarioRepo.findById(id);
    
        if (opt.isPresent()) {
            Funcionario funcionario = opt.get();
            return ResponseEntity.ok(funcionario);
        }
    
        return ResponseEntity.notFound().build();
    }
    

    @PostMapping("/api/Funcionarios")
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario createdFuncionario = funcionarioRepo.save(funcionario);
        return createdFuncionario;
    }

    @PutMapping("/api/Funcionarios/{FuncionarioId}")
    public int updateFuncionario(@RequestBody Funcionario updates, @PathVariable int FuncionarioId) {
        Optional<Funcionario> opt = funcionarioRepo.findById(FuncionarioId);
    
        if (opt.isPresent()) {
            Funcionario funcionario = opt.get();
    
            // Atualizar todos os campos
            funcionario.setNome(updates.getNome());
            funcionario.setCargo(updates.getCargo());
            funcionario.setSalario(updates.getSalario());
    
            // Atualizar a conta associada
            ContaBancaria contaAtualizada = updates.getConta();
            ContaBancaria contaExistente = funcionario.getConta();
    
            if (contaAtualizada != null) {
                // Atualizar a conta existente ou adicionar uma nova conta
                if (contaExistente != null) {
                    contaExistente.setNomeTitular(contaAtualizada.getNomeTitular());
                    contaExistente.setSaldo(contaAtualizada.getSaldo());
                    contaExistente.setAgencia(contaAtualizada.getAgencia());
                } else {
                    ContaBancaria novaConta = new ContaBancaria(
                            contaAtualizada.getIdTitular(),
                            contaAtualizada.getNomeTitular(),
                            contaAtualizada.getSaldo(),
                            contaAtualizada.getAgencia()
                    );
                    funcionario.setConta(novaConta);
                }
            } else {
                // Se contaAtualizada é nula, remover a conta existente
                funcionario.setConta(null);
            }
    
            // Atualizar o produto associado
            Produto produtoAtualizado = updates.getProduto();
            Produto produtoExistente = funcionario.getProduto();
    
            if (produtoAtualizado != null) {
                // Atualizar o produto existente ou adicionar um novo produto
                if (produtoExistente != null) {
                    produtoExistente.setDescricao(produtoAtualizado.getDescricao());
                    produtoExistente.setMarca(produtoAtualizado.getMarca());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                } else {
                    Produto novoProduto = new Produto(
                            produtoAtualizado.getIdProduto(),
                            produtoAtualizado.getDescricao(),
                            produtoAtualizado.getMarca(),
                            produtoAtualizado.getPreco()
                    );
                    funcionario.setProduto(novoProduto);
                }
            } else {
                // Se produtoAtualizado é nulo, remover o produto existente
                funcionario.setProduto(null);
            }

            // Atualizar a cidade associada
            Cidade cidadeAtualizada = updates.getCidade();
            Cidade cidadeExistente = funcionario.getCidade();

            if (cidadeAtualizada != null) {
                // Atualizar a cidade existente ou adicionar uma nova cidade
                if (cidadeExistente != null) {
                    cidadeExistente.setNomeCidade(cidadeAtualizada.getNomeCidade());
                    cidadeExistente.setEstado(cidadeAtualizada.getEstado());
                    cidadeExistente.setPais(cidadeAtualizada.getPais());
                    cidadeExistente.setPopulacao(cidadeAtualizada.getPopulacao());
                } else {
                    Cidade novaCidade = new Cidade(
                            cidadeAtualizada.getIdCidade(),
                            cidadeAtualizada.getNomeCidade(),
                            cidadeAtualizada.getEstado(),
                            cidadeAtualizada.getPais(),
                            cidadeAtualizada.getPopulacao()
                    );
                    funcionario.setCidade(novaCidade);
                }
            } else {
                // Se cidadeAtualizada é nula, remover a cidade existente
                funcionario.setCidade(null);
            }
    
            funcionarioRepo.save(funcionario);
            return FuncionarioId;
        }
    
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do funcionário com id " + FuncionarioId);
    }
    
    @DeleteMapping("/api/Funcionarios/{id}")
    public void deleteFuncionario(@PathVariable int id) {
        funcionarioRepo.deleteById(id);
    }
}
