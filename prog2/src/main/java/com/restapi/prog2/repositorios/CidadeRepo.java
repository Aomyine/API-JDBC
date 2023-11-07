package com.restapi.prog2.repositorios;
import com.restapi.prog2.classes.Cidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepo extends CrudRepository<Cidade, Integer> {
    
}