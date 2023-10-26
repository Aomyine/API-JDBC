package com.restapi.prog2;

public class Produto {

    private int id;
    private String descricao;
    private String marca;
    private Double preco;

    public Produto(int i, String d, String m, Double p){
        this.id = i;
        this.descricao = d;
        this.marca = m;
        this.preco = p;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
