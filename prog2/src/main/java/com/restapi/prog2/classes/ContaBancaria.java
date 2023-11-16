package com.restapi.prog2.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {
    @Id
    @GeneratedValue
    private int idTitular;
    private String nomeTitular;
    private Double saldo;
    private int agencia;
    
    @OneToMany(mappedBy = "conta")
    private List<Funcionario> funcionarios; // Ajuste aqui


    public ContaBancaria() {
        // Construtor vazio necessário para JPA
    }

    public ContaBancaria(int idTitular, String nomeTitular, Double saldo, int agencia) {
        this.idTitular = idTitular;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}