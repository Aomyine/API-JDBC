package com.restapi.prog2;

public class ContaBancaria {
    private int idTitular;
    private String nomeTitular;
    private Double saldo;
    private int agencia;

    public ContaBancaria(int i, String n, Double s, int a){
        this.idTitular = i;
        this.nomeTitular = n;
        this.saldo = s;
        this.agencia = a;
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

}
