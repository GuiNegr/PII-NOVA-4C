package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.Produto;
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
public class ImgProdutoRequestDTO {
    private Long FkIdproduto;
    private String caminhoImg;
    private boolean imgPrincipal;
}
