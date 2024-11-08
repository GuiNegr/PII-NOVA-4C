package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;
import br.com.nova.projeto_nova.bean.entity.StatusPedido;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.exception.NotFoundException;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.PedidoRepository;
import br.com.nova.projeto_nova.repository.UserRepository;
import br.com.nova.projeto_nova.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    GenericMapper mapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public Pedido getById(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    @Override
    public Pedido alterarStatusPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        if (pedido.getStatusPedido().equals(StatusPedido.CANCELADO)) {
            pedido.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
        } else {
            pedido.setStatusPedido(StatusPedido.CANCELADO);
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido criarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido;
        User user = userRepository.findById(pedidoRequestDTO.getIdUser().getIdUsuario()).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        pedido = pedidoRepository.save(mapper.dtoParaEntidade(pedidoRequestDTO, Pedido.class));
        pedido.setIdUser(user);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedido.setDataPedido(pedidoRepository.getDate());
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
