package com.locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocadoraApplication {

    public static void main(String[] args) {
        // Verbos ou Métodos
        // GET => SELECT
        // POST => INSERT
        // DELETE => DELETE
        // PUT => UPDATE

        // Status Code
        // 2xx Sucesso - 200 OK, 201 Created
        // 4xx Erro de quem chamou - 400 Bad Request, 404 Not Found
        // 5xx Erro interno do servidor - 500 Erro interno do servidor

        SpringApplication.run(LocadoraApplication.class, args);

        System.out.println("Rodando...");
    }
}
