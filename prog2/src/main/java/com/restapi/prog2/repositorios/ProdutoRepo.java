package com.restapi.prog2.repositorios;
import com.restapi.prog2.classes.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepo extends CrudRepository<Produto, Long> {
    
}
