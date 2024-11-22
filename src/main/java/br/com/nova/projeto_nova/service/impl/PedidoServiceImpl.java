package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.PedidoResponseDTO;
import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;
import br.com.nova.projeto_nova.bean.entity.StatusPedido;
import br.com.nova.projeto_nova.exception.NotFoundException;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.EnderecoRepository;
import br.com.nova.projeto_nova.repository.PedidoRepository;
import br.com.nova.projeto_nova.repository.UserRepository;
import br.com.nova.projeto_nova.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private GenericMapper mapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private Random rand;

    @Override
    public Pedido getById(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    @Override
    public Pedido alterarStatusPedido(Long id, String status) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        if (status.equalsIgnoreCase("Aguardando Pagamento")) {
            pedido.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
        } else if (status.equalsIgnoreCase("Em Transito")) {
            pedido.setStatusPedido(StatusPedido.EM_TRANSITO);
        } else if (status.equalsIgnoreCase("Pagamento Rejeitado")) {
            pedido.setStatusPedido(StatusPedido.PAGAMENTO_REJEITADO);
        } else if (status.equalsIgnoreCase("Pagamento com Sucesso")) {
            pedido.setStatusPedido(StatusPedido.PAGAMENTO_COM_SUCESSO);
        } else if (status.equalsIgnoreCase("Aguardando Retirada")) {
            pedido.setStatusPedido(StatusPedido.AGUARDANDO_RETIRADA);
        } else {
            pedido.setStatusPedido(StatusPedido.ENTREGUE);
        }
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> criarPedido(List<ProdutoRequestDTO> produtoRequestDTOS, Long idUser,double frete,Long idPedido,String pagamento) {
        List<Pedido> pedidos = new ArrayList<>();
        for(int i = 0; i < produtoRequestDTOS.size(); i++){
            Pedido pedido = new Pedido();
            pedido.setIdUser(userRepository.findById(idUser).orElseThrow(() -> new NotFoundException("USER NÃO ECONTRADO")));
            pedido.setFkEndereco(enderecoRepository.findById(idPedido).orElseThrow());
            pedido.setStatusPedido(StatusPedido.AGUARDANDO_PAGAMENTO);
            pedido.setNomeProduto(produtoRequestDTOS.get(i).getNomeProduto());
            pedido.setDataPedido(pedidoRepository.getDate());
            pedido.setNomeProduto(produtoRequestDTOS.get(i).getNomeProduto());
            pedido.setFormaDePagamento(pagamento);
            pedido.setValorFrete(frete);
            pedido.setValorUnitario(produtoRequestDTOS.get(i).getPrecoProduto());
            pedidos.add(pedido);
        }

        double num = 0;
        for (int j = 0; j < produtoRequestDTOS.size(); j++) {
            num += produtoRequestDTOS.get(j).getPrecoProduto().doubleValue();
        }
        num += frete;
        int u = rand.nextInt(200000);
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.get(i).setValorTotal(num);
            pedidos.get(i).setNumeroPedido(u);
            pedidoRepository.save(pedidos.get(i));
        }
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidos(Long id) {
        return pedidoRepository.findByIdUser(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PedidoResponseDTO> listarPedidos() {
        List<Pedido> pedidoList = pedidoRepository.findAll();
        pedidoList.stream().sorted((p1,p2) -> p2.getDataPedido().compareTo(p1.getDataPedido())).collect(Collectors.toList());
        List<PedidoResponseDTO> pedidoResponseDTOList = mapper.entidadeParaDTO(pedidoList,PedidoResponseDTO.class);
        return pedidoResponseDTOList;
    }
}
