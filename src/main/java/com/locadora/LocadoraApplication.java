package com.locadora;

import com.locadora.model.Aluguel;
import com.locadora.model.Carro;
import com.locadora.model.Cliente;
import com.locadora.repository.AluguelRepository;
import com.locadora.repository.CarroRepository;
import com.locadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner {
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    public static void main(String[] args) {
        SpringApplication.run(LocadoraApplication.class, args);
    }

    @Override
    public void run(String ...args) {
        //System.out.println("Cadastrando um carro no banco");

        Carro carro = new Carro("Toyota", "Corolla", "PKL-9876", 79.9,
                                2015, true);

        //carroRepository.save(carro);

        //System.out.println("Buscando um carro no banco");
        Carro carroProcurado = carroRepository.findByPlaca("PKL-9876");
        //System.out.println(carroProcurado.toString());

        Cliente cliente = new Cliente("Juliana Silva", "222.333.444-99", 25,
                                        2, "(41) 97777-6655");

        //clienteRepository.save(cliente);

        Optional<Carro> carroAlugado = carroRepository.findById(12);
        Optional<Cliente> clienteAlugando = clienteRepository.findById(11);

        if (carroAlugado.isPresent() && clienteAlugando.isPresent()) {
            System.out.println("Cliente e carro encontrado!");
            Aluguel aluguel = new Aluguel(LocalDate.now(), LocalDate.now().plusDays(10), 799.0,
                                            clienteAlugando.get(), carroAlugado.get());
            //aluguelRepository.save(aluguel);
        }

        Optional<Aluguel> aluguel = aluguelRepository.findById(2);

        System.out.println(aluguel.toString());
    }
}