package br.com.nova.projeto_nova.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedidoResponseDTO {
    private Long idItensPedido;
    private Long idPedido;
    private Long idProduto;
    private int quantidade;
    private Double precoUnitario;
    private Double subTotal;
}

