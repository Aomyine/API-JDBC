package com.teste;
import java.sql.*;

public class ConnectionFactory {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://isabelle.db.elephantsql.com:5432/tbucvtri";
            String username = "tbucvtri"; 
            String password = "gNB-MHezOZY_g7MQn37Ju6dC3706DoIx";
            
            connection = DriverManager.getConnection(url, username, password);
            return connection;
            
        } catch (ClassNotFoundException e) {            
            System.out.println("O driver especificado não foi encontrado.");
            return null;
            
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados.");
            return null;
        }
    }
}