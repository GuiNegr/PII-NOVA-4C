package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
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
