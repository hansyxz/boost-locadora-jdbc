package com.locadora;

import com.locadora.model.Carro;
import com.locadora.repository.CarroRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarroRepository repositorio =  new CarroRepository();

        // Salvar
        Carro carro = new Carro("Chevrolet", "Onix", "JJJ-1234",
                89.99, 2022, true);

        carro.setValorDiaria(160.00);

        repositorio.salvar(carro);

        // Listar
        List<Carro> carros = repositorio.listar();

        carros.forEach(c -> {
            System.out.println("----------------");
            System.out.println(c.toString());
        });
    }
}