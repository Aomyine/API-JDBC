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
    public Iterable<Funcionario> getFuncionarios() {
        return funcionarioRepo.findAll();
    }

    @GetMapping("/api/Funcionarios/{id}")
    public Optional<Funcionario> getFuncionario(@PathVariable int id) {
        return funcionarioRepo.findById(id);
    }

    @PostMapping("/api/Funcionarios")
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario createdFuncionario = funcionarioRepo.save(funcionario);
        return createdFuncionario;
    }

    @PutMapping("/api/Funcionarios/{FuncionarioId}")
    public int updateFuncionario(@RequestBody Funcionario funcionarioRequest, @PathVariable int FuncionarioId) {
        Optional<Funcionario> opt = funcionarioRepo.findById(FuncionarioId);
        if (opt.isPresent()) {
            if (funcionarioRequest.getId() == FuncionarioId) {
                funcionarioRepo.save(funcionarioRequest);
                return FuncionarioId;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do funcionário com id " + FuncionarioId);
    }

    @DeleteMapping("/api/Funcionarios/{id}")
    public void deleteFuncionario(@PathVariable int id) {
        funcionarioRepo.deleteById(id);
    }
}
