package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.ItensPedido;
import br.com.nova.projeto_nova.bean.entity.StatusPedido;
import br.com.nova.projeto_nova.bean.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {
    private Long idPedido;
    private Long idUser;
    private List<ItensPedidoRequestDTO> itensPedidos;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private LocalDateTime dataPedido;
}
