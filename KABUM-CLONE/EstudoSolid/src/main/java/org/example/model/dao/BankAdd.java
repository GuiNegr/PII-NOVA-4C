package org.example.model.dao;

import org.example.model.estoquista.Estoquista;
import org.example.model.administrador.Administrador;
import org.example.model.pessoa.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankAdd {


    public void adicionaPessoa(Pessoa pessoa){
        String sqlPessoa = "insert into pessoas (nome,cpf,rg,dataNascimento,TIPO) values (?,?,?,?,?)";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlPessoa);
        ){
          preparedStatement.setString(1,pessoa.getNome());
          preparedStatement.setString(2,pessoa.getCpf());
          preparedStatement.setString(3,pessoa.getRg());
          preparedStatement.setString(4, pessoa.getDataNascimento());
          preparedStatement.setString(5, pessoa.getTipo());
          preparedStatement.execute();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void adicionaCliente(Estoquista pessoa){
        String sqlCLiente = "insert into CLIENTE (id_fk_pessoa,saldo) values (?,?)";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlCLiente);
        ){
            preparedStatement.setString(1,BankSelect.returnIDpessoa(pessoa));
            preparedStatement.setDouble(2,pessoa.getSaldo());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void adicionaFuncionario(Administrador pessoa){
        String sqlCLiente = "insert into FUncionario (id_fk_pessoa,salario) values (?,?)";
        try(
                Connection connection = BankConnection.obterConexao();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlCLiente);
        ){
            preparedStatement.setString(1,BankSelect.returnIDpessoa(pessoa));
            preparedStatement.setDouble(2,pessoa.getSalario());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
