package com.restapi.prog2.repositorios;
import com.restapi.prog2.classes.ContaBancaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepo extends CrudRepository<ContaBancaria, Integer> {

}