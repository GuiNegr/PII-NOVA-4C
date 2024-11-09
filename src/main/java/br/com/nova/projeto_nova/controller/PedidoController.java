package br.com.nova.projeto_nova.controller;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.PedidoResponseDTO;
import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;
import br.com.nova.projeto_nova.bean.entity.Produto;
import br.com.nova.projeto_nova.mapper.GenericMapper;

import br.com.nova.projeto_nova.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;
    @Autowired
    private final GenericMapper mapper;

    @GetMapping("/listById/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(@PathVariable Long id){
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.listarPedidos(id), PedidoResponseDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.getById(id), PedidoResponseDTO.class));
    }

    @PostMapping("/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> criarPedido(@RequestBody List<ProdutoRequestDTO> produtoRequestDTO,@PathVariable Long id) {
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.criarPedido(produtoRequestDTO,id),PedidoResponseDTO.class));
    }

    @PutMapping("/altStatus/{id}")
    public ResponseEntity<PedidoResponseDTO> alterarStatusPedido(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.alterarStatusPedido(id), PedidoResponseDTO.class));
    }



}