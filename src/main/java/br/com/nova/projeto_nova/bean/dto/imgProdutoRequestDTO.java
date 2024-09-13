package br.com.nova.projeto_nova.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class imgProdutoRequestDTO {
    private long idImgProd;
    private long idFkProd;
    private String nomeImgProd;
    private String caminhoImg;
    private boolean imgPrincipal;
}
