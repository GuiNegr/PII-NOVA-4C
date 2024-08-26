package org.example.model.cliente;


import org.example.model.pessoa.Pessoa;
import org.example.model.pessoa.Tipo;

public class Cliente extends Pessoa {


    private String id;
    private String idFkPessoa;
    private String numeroConta;
    private double saldo;


    public Cliente(String nome, String cpf, String rg, String dataNascimento, Tipo.tipo tipo,String idFkPessoa, double saldo) {
        super(nome, cpf, rg, dataNascimento, tipo);
        this.idFkPessoa = idFkPessoa;
        this.saldo = saldo;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getIdFkPessoa() {
        return idFkPessoa;
    }

    public void setIdFkPessoa(String idFkPessoa) {
        this.idFkPessoa = idFkPessoa;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
