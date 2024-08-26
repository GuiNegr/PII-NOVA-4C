package org.example.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/GuiBank";
    private static final String LOGIN = "Root";
    private static final String PASSWORD = "root";


    public static Connection obterConexao(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            return  connection;
        }catch (Exception e){
            return connection;
        }
    }
}
