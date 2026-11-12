package com.locadora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private Integer idade;

    @Column(name = "tempo_aluguel_dias")
    private Integer tempoAluguelDias;

    private String telefone;

    public Cliente() {}

    public Cliente(String nome, String cpf, Integer idade, Integer tempoAluguelDias, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.tempoAluguelDias = tempoAluguelDias;
        this.telefone = telefone;
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Integer getIdade() { return idade; }
    public Integer getTempoAluguelDias() { return tempoAluguelDias; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Tempo de aluguel em dias: " + tempoAluguelDias + "\n" +
                "Telefone: "+ telefone;
    }
}
