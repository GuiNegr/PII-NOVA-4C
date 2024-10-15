package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.User;

public class EnderecoRequestDTO {
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private boolean enderecoPrincipal;
    private User fkUser;
}
