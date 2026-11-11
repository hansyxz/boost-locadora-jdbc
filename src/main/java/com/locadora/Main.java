package com.locadora;

import com.locadora.model.Carro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro("Chevrolet", "Onix", "XYZ-1234",
                119.99, 2022, true);

        carro.setValorDiaria(160.00);

        //System.out.println(carro.toString());

        try {

            System.out.println("Novo carro criado na tabela carros!");

            Connection conexao = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão efetuada com sucesso!");

            String sql = "SELECT id, marca, modelo, placa, valor_diaria, ano_de_lancamento, disponivel FROM carros";

            PreparedStatement comando = conexao.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();
            // resultado está na linha 0 da tabela
//            resultado.next();
//            resultado.next();
//            resultado.next();
            // resultado está na linha 1 da tabela
//            System.out.println(resultado.getString("marca"));

            while (resultado.next()) { // Passa pra proxima linha e retorna true se ela existir
                int id = resultado.getInt("id");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                String placa = resultado.getString("placa");
                double valorDiaria = resultado.getDouble("valor_diaria");
                int ano = resultado.getInt("ano_de_lancamento");
                boolean disponivel = resultado.getBoolean("disponivel");

                Carro novoCarro = new Carro(id, marca, modelo, placa, valorDiaria, ano, disponivel);

                System.out.println(novoCarro.toString() + "\n-----------------------");
            }

            conexao.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}