package com.restapi.prog2.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {
    @Id
    @GeneratedValue
    private int idTitular;
    private String nomeTitular;
    private Double saldo;
    private int agencia;
    
    @JsonBackReference
    @OneToOne(mappedBy = "conta")
    private Funcionario funcionario;

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
