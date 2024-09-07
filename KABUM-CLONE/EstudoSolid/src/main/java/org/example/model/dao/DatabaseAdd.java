package org.example.model.dao;

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

    public static void trocaSenha(String email,String senha){
        String sql = "UPDATE users set senha = ? where email = ? ";
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){
            preparedStatement.setString(1,senha);
            preparedStatement.setString(2,email);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static void trocarSenhaById(String senha,Long id) {
        String sql = "update users set senha = ? where id = ?";
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1,senha);
            preparedStatement.setLong(2,id);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public static void updateUsuario(User user) {
        String querySQL = "update users set nome = ?, cpf = ?, grupo = ? where id = ?";
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
        ){
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getGrupo().name());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void trocaStatus(String status, Long id) {
        String sql = "UPDATE users set STATUS = ? where id = ?";
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, status);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Erro em atualizar o status: " + e.getMessage());
        }
    }
}
