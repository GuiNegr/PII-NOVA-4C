package org.example.dao;

import org.example.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSelect {

    public static String returnIDpessoa(User user){
        String url = "select * from pessoas where CPF = ?";
        String id = "";
        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1, user.getCpf());
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
                Connection connection = DatabaseConnect.obterConexao();
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