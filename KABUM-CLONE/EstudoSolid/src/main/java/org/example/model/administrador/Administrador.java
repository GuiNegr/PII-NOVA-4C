package org.example.model.administrador;

import org.example.model.pessoa.Pessoa;
import org.example.model.pessoa.Tipo;

public class Administrador extends Pessoa{

       private String id;
       private String idFKPessoa;
       private double salario;

    public Administrador(String nome, String cpf, String rg, String dataNascimento, Tipo.tipo tipo, String idFKPessoa, double salario) {
        super(nome, cpf, rg, dataNascimento, tipo);
        this.idFKPessoa = idFKPessoa;
        this.salario = salario;
    }


    public String getIdFKPessoa() {
        return idFKPessoa;
    }

    public void setIdFKPessoa(String idFKPessoa) {
        this.idFKPessoa = idFKPessoa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
