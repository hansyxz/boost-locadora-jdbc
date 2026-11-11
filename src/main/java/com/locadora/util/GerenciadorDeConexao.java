package com.locadora.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorDeConexao {
    private static final String URL = "jdbc:mysql://localhost:3306/locadora_db";
    private static final String USER = "root";
    private static final String SENHA = "12345678";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }
}
