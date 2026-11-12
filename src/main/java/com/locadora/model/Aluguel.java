package com.locadora.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_de_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_de_fim")
    private LocalDate dataFim;

    @Column(name = "valor_total")
    private Double valorTotal;

    // N : 1
    @ManyToOne
    @JoinColumn(name = "cliente_id") // cliente que tenha o id igual o cliente_id
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    public Aluguel() {}

    public Aluguel(LocalDate dataInicio, LocalDate dataFim, Double valorTotal, Cliente cliente, Carro carro) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.carro = carro;
    }

    public Integer getId() { return id; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public Double getValorTotal() { return valorTotal; }
    public Cliente getCliente() { return cliente; }
    public Carro getCarro() { return carro; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Data de inicio: " + dataInicio + "\n" +
                "Data de fim: " + dataFim + "\n" +
                "Valor total: " + valorTotal + "\n" +
                "Nome do cliente: " + cliente.getNome() + "\n" +
                "Placa do carro: "+ carro.getPlaca();
    }
}
