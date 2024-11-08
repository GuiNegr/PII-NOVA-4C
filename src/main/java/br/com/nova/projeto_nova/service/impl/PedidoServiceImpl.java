package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;
import br.com.nova.projeto_nova.bean.entity.StatusPedido;
import br.com.nova.projeto_nova.exception.NotFoundException;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.PedidoRepository;
import br.com.nova.projeto_nova.repository.ProdutoRepository;
import br.com.nova.projeto_nova.repository.UserRepository;
import br.com.nova.projeto_nova.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    GenericMapper mapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    Random rand;

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
    public List<Pedido> criarPedido(List<ProdutoRequestDTO> produtoRequestDTOS, Long idUser) {
        List<Pedido> pedidos = new ArrayList<>();
        for(int i = 0; i < produtoRequestDTOS.size(); i++){
            Pedido pedido = new Pedido();
            pedido.setIdUser(userRepository.findById(idUser).orElseThrow(() -> new NotFoundException("USER NÃO ECONTRADO")));

            pedido.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
            pedido.setNomeProduto(produtoRequestDTOS.get(i).getNomeProduto());
            pedido.setDataPedido(pedidoRepository.getDate());
            pedidos.add(pedido);
        }

        double num = 0;
        for (int j = 0; j < produtoRequestDTOS.size(); j++) {
            num += produtoRequestDTOS.get(j).getPrecoProduto().doubleValue();
        }
        int u = rand.nextInt(200000);
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.get(i).setValorTotal(num);
            pedidos.get(i).setNumeroPedido(u);
            pedidoRepository.save(pedidos.get(i));
        }
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
