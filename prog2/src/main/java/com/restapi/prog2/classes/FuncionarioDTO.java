package com.restapi.prog2.classes;

public class FuncionarioDTO {
    private String nome;
    private String cargo;
    private Double salario;
    private long contaId;
    private long cidadeId;
    private long produtoId;
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
    public long getContaId() {
        return contaId;
    }
    public void setContaId(long contaId) {
        this.contaId = contaId;
    }
    public long getCidadeId() {
        return cidadeId;
    }
    public void setCidadeId(long cidadeId) {
        this.cidadeId = cidadeId;
    }
    public long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }


    
}
