package com.locadora.controller;

import com.locadora.model.Carro;
import com.locadora.model.DiariaRequest;
import com.locadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public ResponseEntity<List<Carro>> listarTodos() {
        List<Carro> carros = carroRepository.findAll();

        // ResponseEntity
        //return ResponseEntity.ok(carros);
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable("id") Integer id) {
        Optional<Carro> carro = carroRepository.findById(id);

        return ResponseEntity.of(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody Carro carro) {
        Carro carroCadastrado = carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroCadastrado);
        // Falta fazer um tratamento de erro
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        boolean existe = carroRepository.existsById(id);

        if (existe) {
            carroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable("id") Integer id, @RequestBody DiariaRequest request) {
        System.out.println("Chamou");
        Optional<Carro> carrDesatualizado = carroRepository.findById(id);

        if (carrDesatualizado.isPresent()) {
            Carro carro = carrDesatualizado.get();

            carro.setValorDiaria(request.valorDiaria());

            Carro carroAtualizado = carroRepository.save(carro);

            return ResponseEntity.status(HttpStatus.CREATED).body(carroAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
