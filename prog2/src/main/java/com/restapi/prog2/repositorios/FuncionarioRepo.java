package com.restapi.prog2.repositorios;
import com.restapi.prog2.classes.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepo extends CrudRepository<Funcionario, Integer> {
    
}