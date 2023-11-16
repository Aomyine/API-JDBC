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
    public Optional<Funcionario> getFuncionario(@PathVariable int id) {
        return funcionarioRepo.findById(id);
    }


    @GetMapping("/api/Funcionarios/detalhes/{id}")
    public ResponseEntity<Map<String, Object>> getDetalhesFuncionario(@PathVariable int id) {
        Optional<Funcionario> funcionario = funcionarioRepo.findById(id);

        if (funcionario.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("funcionario", funcionario.get());
            response.put("conta", funcionario.get().getConta());
            response.put("cidade", funcionario.get().getCidade());
            response.put("produto", funcionario.get().getProduto());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/Funcionarios/detalhes/todos")
    public ResponseEntity<List<Map<String, Object>>> getDetalhesTodosFuncionarios() {
        Iterable<Funcionario> funcionariosIterable = funcionarioRepo.findAll();
    
        // Convertendo para uma lista
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionariosIterable.forEach(funcionarios::add);
    
        if (!funcionarios.isEmpty()) {
            List<Map<String, Object>> responseList = new ArrayList<>();
    
            for (Funcionario funcionario : funcionarios) {
                Map<String, Object> response = new HashMap<>();
                response.put("funcionario", funcionario);
                response.put("conta", funcionario.getConta());
                response.put("cidade", funcionario.getCidade());
                response.put("produto", funcionario.getProduto());
                responseList.add(response);
            }
    
            return ResponseEntity.ok(responseList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/Funcionarios")
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario createdFuncionario = funcionarioRepo.save(funcionario);
        return createdFuncionario;
    }

    @PutMapping("/api/Funcionarios/{FuncionarioId}")
    public int updateFuncionario(@RequestBody Map<String, Object> updates, @PathVariable int FuncionarioId) {
        Optional<Funcionario> opt = funcionarioRepo.findById(FuncionarioId);
    
        if (opt.isPresent()) {
            Funcionario funcionario = opt.get();
    
            // Atualizar apenas os campos fornecidos no corpo da solicitação
            updates.forEach((key, value) -> {
                switch (key) {
                    case "nome":
                        funcionario.setNome((String) value);
                        break;
                    case "cargo":
                        funcionario.setCargo((String) value);
                        break;
                    case "salario":
                        funcionario.setSalario((Double) value);
                        break;
                    // Adicione mais casos para outros campos, se necessário
                }
            });
    
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
