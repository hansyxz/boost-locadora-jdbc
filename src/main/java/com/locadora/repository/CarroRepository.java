package com.locadora.repository;

import com.locadora.model.Carro;
import com.locadora.util.GerenciadorDeConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {
    public void salvar (Carro carro) {
        String sql = "INSERT INTO carros (marca, modelo, placa, valor_diaria, ano_de_lancamento, disponivel) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = GerenciadorDeConexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, carro.getMarca());
            comando.setString(2, carro.getModelo());
            comando.setString(3, carro.getPlaca());
            comando.setDouble(4, carro.getValorDiaria());
            comando.setInt(5, carro.getAnoDeLancamento());
            comando.setBoolean(6, carro.getDisponivel());

            comando.executeUpdate();

            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public List<Carro> listar() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT id, marca, modelo, placa, valor_diaria, ano_de_lancamento, disponivel FROM carros";

        try {
            Connection conexao = GerenciadorDeConexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                String placa = resultado.getString("placa");
                Double valorDiaria = resultado.getDouble("valor_diaria");
                int anoDeLancamento = resultado.getInt("ano_de_lancamento");
                boolean disponivel = resultado.getBoolean("disponivel");

                Carro carro = new Carro(id, marca, modelo, placa, valorDiaria, anoDeLancamento, disponivel);

                carros.add(carro);
            }

            conexao.close();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return carros;
    }
}
