package com.restapi.prog2;

public class Cidade {

    private int idCidade;
    private String nomeCidade;
    private String estado;
    private String pais;
    private int populacao;

    public Cidade (int i, String n, String e, String pa, int po){
        this.idCidade = i;
        this.nomeCidade = n;
        this.estado = e;
        this.pais = pa;
        this.populacao = po;
    }
    


    public int getIdCidade() {
        return idCidade;
    }

   
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }


    public String getNomeCidade() {
        return nomeCidade;
    }


    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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
