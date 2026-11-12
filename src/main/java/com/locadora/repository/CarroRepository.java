package com.locadora.repository;

import com.locadora.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
    Carro findByPlaca(String placa);
}
