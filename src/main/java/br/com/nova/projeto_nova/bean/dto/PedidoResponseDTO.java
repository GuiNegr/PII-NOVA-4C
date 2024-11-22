package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.StatusPedido;
import br.com.nova.projeto_nova.bean.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoResponseDTO {
    private Long idPedido;
    private User idUser;
    private String nomeProduto;
    private StatusPedido statusPedido;
    private LocalDateTime dataPedido;
    private Double valorTotal;
    private int numeroPedido;
    private String formaDePagamento;
    private BigDecimal valorUnitario;
    private int quantidade;
    private Double valorFrete;
    private Endereco fkEndereco;
}
