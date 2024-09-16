package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProdutoResponseDTO {
    private String nomeProduto;
    private String descDetalhadaProduto;
    private BigDecimal precoProduto;
    private int qtdEstoqueProduto;
    private Double avalProduto;
    private LocalDateTime prodDhCadastro;
    private LocalDateTime prodDhInativo;
}
