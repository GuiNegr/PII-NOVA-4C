package org.example.model.user;


public  class User {


    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Tipo.Grupo Grupo;
    private Status.StatusDatabase statusDatabase;

    public User() {
    }

    public User(String nome, String cpf, String email, String senha, Tipo.Grupo grupo, Status.StatusDatabase statusDatabase) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        Grupo = grupo;
        this.statusDatabase = statusDatabase;
    }

    public User(Long id, String nome, String cpf, String email, String senha, Tipo.Grupo grupo, Status.StatusDatabase statusDatabase) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        Grupo = grupo;
        this.statusDatabase = statusDatabase;
    }

    public User(Long id, String nome, String cpf, String email, Tipo.Grupo grupo, Status.StatusDatabase statusDatabase) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        Grupo = grupo;
        this.statusDatabase = statusDatabase;
    }

    @Override
    public String toString() {
        return
                "id:'" + id + '\'' +
                ", nome:'" + nome + '\'' +
                ", cpf:'" + cpf + '\'' +
                ", email:'" + email + '\'' +
                ", Grupo:" + Grupo +
                ", Status:" + statusDatabase;

    }

    public void setGrupo(Tipo.Grupo grupo) {
        Grupo = grupo;
    }

    public String getStatus() {
        return String.valueOf(this.statusDatabase);
    }

    public void setStatus(Status.StatusDatabase statusDatabase) {
        this.statusDatabase = statusDatabase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return Grupo.toString();
    }

    public void setTipo(Tipo.Grupo Grupo) {
        this.Grupo = Grupo;
    }

    public Tipo.Grupo getGrupo() {
        return Grupo;
    }
}
