package com.restapi.prog2;

public class Cidade {

    private int id;
    private String nome;
    private String estado;
    private String pais;
    private int populacao;

    public Cidade (int i, String n, String e, String pa, int po){
        this.id = i;
        this.nome = n;
        this.estado = e;
        this.pais = pa;
        this.populacao = po;
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


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }


    public int getPopulacao() {
        return populacao;
    }

    
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

}
