package org.example.model.pessoa;

public class Pessoa  {

    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Tipo.tipo tipo;



    public Pessoa(String nome, String cpf, String email, String senha, Tipo.tipo tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public void setTipo(Tipo.tipo tipo) {
        this.tipo = tipo;
    }
}
