package com.restapi.prog2.classes;

public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private Double salario;
    private Cidade cidade;
    private ContaBancaria conta;

    public Funcionario(int i, String n, String c, Double s, Cidade ci, ContaBancaria co){
        this.id = i;
        this.nome = n;
        this.cargo = c;
        this.salario = s;
        this.cidade = ci;
        this.conta = co;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Double getSalario() {
        return salario;
    }


    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

}
