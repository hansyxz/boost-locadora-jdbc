package com.locadora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;
    private String modelo;
    private String placa;
    private Double valorDiaria;
    private Integer anoDeLancamento;
    private Boolean disponivel;

    public Carro() {}

    public Carro(String marca, String modelo, String placa, Double valorDiaria,
                 Integer anoDeLancamento, Boolean disponivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.anoDeLancamento = anoDeLancamento;
        this.disponivel = disponivel;
    }

    public Integer getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }
    public Double getValorDiaria() { return valorDiaria; }
    public Integer getAnoDeLancamento() { return anoDeLancamento; }
    public Boolean getDisponivel() { return disponivel; }

    public void setValorDiaria(Double valorDiaria) { this.valorDiaria = valorDiaria; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Placa: " + placa + "\n" +
                "Valor Diaria: R$ " + valorDiaria + "/dia\n" +
                "Ano de Lancamento: " + anoDeLancamento + "\n" +
                "Disponivel: " + (disponivel ? "Sim" : "Não");
    }
}
