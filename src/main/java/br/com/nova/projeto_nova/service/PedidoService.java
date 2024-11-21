package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.PedidoResponseDTO;
import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido getById(Long id);
    Pedido alterarStatusPedido(Long id, String status);
    List<Pedido> criarPedido(List<ProdutoRequestDTO> produtoRequestDTOS, Long idUser,double frete,Long idEndereco);
    List<Pedido> listarPedidos(Long idUser);
    List<PedidoResponseDTO> listarPedidos();
}
