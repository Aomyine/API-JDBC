package com.restapi.prog2;

public class ContaBancaria {
    private int id;
    private String nomeTitular;
    private Double saldo;
    private int agencia;

    public ContaBancaria(int i, String n, Double s, int a){
        this.id = i;
        this.nomeTitular = n;
        this.saldo = s;
        this.agencia = a;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
