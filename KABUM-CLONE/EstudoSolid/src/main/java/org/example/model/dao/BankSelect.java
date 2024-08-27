package org.example.model.dao;

import org.example.model.pessoa.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankSelect {

    public static String returnIDpessoa(Pessoa pessoa){
        String url = "select * from pessoas where CPF = ?";
        String id = "";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,pessoa.getCpf());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getString("ID");
            }
            return id;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return id;
        }
    }
    public static boolean returnIfEmailExist(String emailOut){
        String url = "select * from users where email = ?";
        String email = "";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,emailOut);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                email = resultSet.getString("email");
            }
            if(email.equals(emailOut)){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
