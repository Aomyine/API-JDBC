package com.restapi.prog2.classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cargo;
    private Double salario;

    @OneToOne
    private ContaBancaria conta;

    @ManyToOne
    private Cidade cidade;

    @ManyToOne
    private Produto produto;

    public Funcionario() {
        // Construtor vazio necessário para JPA
    }

    public Funcionario(long id, String nome, String cargo, Double salario, Cidade cidade, ContaBancaria conta, Produto produto) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.cidade = cidade;
        this.conta = conta;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
