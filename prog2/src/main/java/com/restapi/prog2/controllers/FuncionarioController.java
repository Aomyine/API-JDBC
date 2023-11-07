package com.restapi.prog2.controllers;

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
import com.restapi.prog2.classes.Funcionario;

@RestController
public class FuncionarioController {

    private List<Funcionario> Funcionarios;

    public FuncionarioController() {
        this.Funcionarios = new ArrayList<>();
    }

    @GetMapping("/api/Funcionarios")
    Iterable<Funcionario> getFuncionarios() {
        return this.Funcionarios;
    }

    @GetMapping("/api/Funcionarios/{id}")
    Optional<Funcionario> getFuncionario(@PathVariable int id) {
        return this.Funcionarios.stream()
            .filter(f -> f.getId() == id)
            .findFirst();
    }

    @PostMapping("/api/Funcionarios")
    Funcionario createFuncionario(@RequestBody Funcionario f) {
        int maxId = this.Funcionarios.stream()
            .map(Funcionario::getId)
            .max(Integer::compare)
            .orElse(0);
        f.setId(maxId + 1);
        this.Funcionarios.add(f);
        return f;
    }

    @PutMapping("/api/Funcionarios/{FuncionarioId}")
    Optional<Funcionario> updateFuncionario(@RequestBody Funcionario FuncionarioRequest, @PathVariable int FuncionarioId) {
        Optional<Funcionario> opt = getFuncionario(FuncionarioId);
        if (opt.isPresent()) {
            Funcionario funcionario = opt.get();
            funcionario.setNome(FuncionarioRequest.getNome());
            funcionario.setCargo(FuncionarioRequest.getCargo());
            funcionario.setSalario(FuncionarioRequest.getSalario());
            funcionario.setCidade(FuncionarioRequest.getCidade());
            funcionario.setConta(FuncionarioRequest.getConta());
        }

        return opt;
    }

    @DeleteMapping(value = "/api/Funcionarios/{id}")
    void deleteFuncionario(@PathVariable int id) {
        this.Funcionarios.removeIf(f -> f.getId() == id);
    }
}