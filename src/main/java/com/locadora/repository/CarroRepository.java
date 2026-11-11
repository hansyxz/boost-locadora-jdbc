package com.locadora.repository;

import com.locadora.model.Carro;
import com.locadora.util.GerenciadorDeConexao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    //List<Carro>
    public void listar() {

    }
}
