package org.example.model.dao;

import org.example.model.user.Status;
import org.example.model.user.Tipo;
import org.example.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSelect {

    public static User returnUserPorID(Long id) {
        String query = "select * from users where id = ?";
        Long idUserInBd = null;
        String  cpfInBd = "";
        String emailInBd = "";
        String nameInBd = "";
        String status = "";
        String grupoNoBanco = "";
        Tipo.Grupo grupo = null;
        Status.StatusDatabase statusUser = null;
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(query);)
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                idUserInBd = resultSet.getLong("id");
                nameInBd = resultSet.getString("nome");
                cpfInBd = resultSet.getString("cpf");
                emailInBd = resultSet.getString("email");
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(idUserInBd, nameInBd, cpfInBd, emailInBd, grupo, statusUser);
    }

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
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
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
        Long id = null;
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
                 id = resultSet.getLong("id");
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

            return new User(id,nameInBd,cpfInBd,email,passInBd,grupo,statusUser);
        }catch (SQLException e){
            System.out.println(e.getMessage());
           return user;
        }
    }

    public static List<User> listarUsuarios() {
        String url = "select * from users";
        List<User> usuarios = new ArrayList<>();
        try (
                Connection connection = DatabaseConnect.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(url);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setNome(resultSet.getString("nome"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(Status.StatusDatabase.valueOf(resultSet.getString("status").toUpperCase()));
                user.setGrupo(Tipo.Grupo.valueOf(resultSet.getString("grupo").toUpperCase()));
                user.setCpf(resultSet.getString("cpf"));  // Adiciona CPF ao objeto User
                usuarios.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }
}
