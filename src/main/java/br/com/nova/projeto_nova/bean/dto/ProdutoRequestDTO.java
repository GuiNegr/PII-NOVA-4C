package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProdutoRequestDTO {
    private Long idProduto;
    private String nomeProduto;
    private String descDetalhadaProduto;
    private double precoProduto;
    private int qtdEstoqueProduto;
    private Double avalProduto;
    private ArrayList<ImgProduto> listaImg;
}
