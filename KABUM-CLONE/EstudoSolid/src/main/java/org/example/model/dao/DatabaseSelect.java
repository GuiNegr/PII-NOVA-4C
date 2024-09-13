package org.example.model.dao;

import org.example.model.user.Status;
import org.example.model.user.Tipo;
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
    public static boolean retornaSeOEMailExiste(String emailOut){
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

    public static String retornaOGrupo(String email){
        String url = "select * from users where email = ?";
        String tipo = "";
        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tipo = resultSet.getString("grupo");
            }
            return tipo;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return tipo;
        }
    }
    public static boolean retornaSeNaoForCliente(String email){
        String url = "select * from users where email = ?";
        String tipo = "";
        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tipo = resultSet.getString("grupo");
            }
            if(tipo.equalsIgnoreCase("cliente")){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean retornaUmLogin(String pass, String email){
        String url = "select * from users where email = ?";
        String passINBd = "";
        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                passINBd = resultSet.getString("senha");
            }
            if(pass.equals(passINBd)){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static  User returnUserComplete(String email){
        String url = "select * from users where email = ?";
        User user = null;
        String cpfInBd = "";
        String passInBd = "";
        String nameInBd = "";
        String status = "";
        String grupoNoBanco = "";
        Tipo.Grupo  grupo = null;
        Status.StatusDatabase statusUser = null;

        try(
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
        ){
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 cpfInBd = resultSet.getString("cpf");
                 passInBd = resultSet.getString("senha");
                 nameInBd = resultSet.getString("nome");
                 status = resultSet.getString("STATUS");
                 grupoNoBanco = resultSet.getString("grupo");
            }
            if(status.equalsIgnoreCase("habilitado")){
                statusUser = Status.StatusDatabase.HABILITADO;
            }else if(status.equalsIgnoreCase("desabilitado")){
                statusUser = Status.StatusDatabase.DESABILITADO;
            }

            if(grupoNoBanco.equalsIgnoreCase("administrador")){
               grupo = Tipo.Grupo.ADMINISTRADOR;
            }else if(grupoNoBanco.equalsIgnoreCase("estoquista")){
                grupo = Tipo.Grupo.ESTOQUISTA;
            }

            return user = new User(nameInBd,cpfInBd,email,passInBd,grupo,statusUser);
        }catch (SQLException e){
            System.out.println(e.getMessage());
           return user;
        }
    }
}
