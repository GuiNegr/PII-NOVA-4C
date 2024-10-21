package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.User;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private boolean enderecoPrincipal;
    private String grupo;
    private User fkUser;
}
