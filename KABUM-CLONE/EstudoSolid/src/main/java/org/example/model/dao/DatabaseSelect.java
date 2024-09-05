package org.example.model.dao;

import org.example.model.user.Status;
import org.example.model.user.Tipo;
import org.example.model.user.User;
import org.example.model.dao.*;
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
    public static User getUserById(int userId) {
        String sql = "SELECT id, nome, cpf, email, senha, grupo, status FROM users WHERE id = ?";
        User user = null;

        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Tipo.Grupo grupo = Tipo.Grupo.valueOf(resultSet.getString("grupo").toUpperCase());
                Status.StatusDatabase statusDatabase = Status.StatusDatabase.valueOf(resultSet.getString("status").toUpperCase());

                user = new User(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        grupo,
                        statusDatabase
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por ID: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Valor inválido encontrado para grupo ou status: " + e.getMessage());
        }

        return user;
    }
}