package br.com.nova.projeto_nova.bean.dto;

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
public class ItensPedidoRequestDTO {
    private Long idPedido;
    private Long idProduto;
    private int quantidade;
    private Double precoUnitario;
    private Double subTotal;
}
