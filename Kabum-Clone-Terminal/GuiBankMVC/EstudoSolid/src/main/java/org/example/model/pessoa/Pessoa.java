package org.example.model.pessoa;

public class Pessoa  {

    private String id;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private Tipo.tipo tipo;


    public Pessoa(String nome, String cpf, String rg, String dataNascimento, Tipo.tipo tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public void setTipo(Tipo.tipo tipo) {
        this.tipo = tipo;
    }
}
