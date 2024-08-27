package org.example.model.dao;

import org.example.model.pessoa.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAdd {


    public static void  adicionaPessoa(Pessoa pessoa){
        String sqlPessoa = "insert into users (nome,cpf,email,senha,grupo) values (?,?,?,?,?)";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlPessoa);
        ){
          preparedStatement.setString(1,pessoa.getNome());
          preparedStatement.setString(2,pessoa.getCpf());
          preparedStatement.setString(3,pessoa.getEmail());
          preparedStatement.setString(4, pessoa.getSenha());
          preparedStatement.setString(5, pessoa.getTipo());
          preparedStatement.execute();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
