package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido getById(Long id);
    Pedido alterarStatusPedido(Long id);
    Pedido criarPedido(PedidoRequestDTO pedidoRequestDTO);
    List<Pedido> listarPedidos();
}
