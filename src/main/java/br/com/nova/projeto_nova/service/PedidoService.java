package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;

public interface PedidoService {
    Pedido getById(Long id);
    Pedido alterarPedido(Long id, PedidoRequestDTO pedidoRequestDTO);
    Pedido salvar(Pedido pedido);
    Pedido criarPedido(PedidoRequestDTO pedidoRequestDTO);
}
