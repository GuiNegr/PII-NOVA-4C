package org.example.dao;

import org.example.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAdd {


    public void  adicionaPessoa(User user){
        String sqlPessoa = "insert into users (nome,cpf,email,senha,grupo,status) values (?,?,?,?,?,?)";
        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlPessoa);
        ){
          preparedStatement.setString(1, user.getNome());
          preparedStatement.setString(2, user.getCpf());
          preparedStatement.setString(3, user.getEmail());
          preparedStatement.setString(4, user.getSenha());
          preparedStatement.setString(5, user.getTipo());
          preparedStatement.setString(6,user.getStatus());
          preparedStatement.execute();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
