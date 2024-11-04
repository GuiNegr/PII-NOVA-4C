package br.com.nova.projeto_nova.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItensCarrinhoResponseDTO {
    private Long idItensCarrinho;
    private Long idCarrinho;
    private Long idProduto;
    private int quantidade;
    private Double precoUnitario;
    private Double subTotal;
}
