package com.restapi.prog2.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {
    @Id
    @GeneratedValue
    private long idTitular;
    private String nomeTitular;
    private Double saldo;
    private int agencia;


    public ContaBancaria() {
        // Construtor vazio necessário para JPA
    }

    public ContaBancaria(long idTitular, String nomeTitular, Double saldo, int agencia) {
        this.idTitular = idTitular;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public long getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(long idTitular) {
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

}
