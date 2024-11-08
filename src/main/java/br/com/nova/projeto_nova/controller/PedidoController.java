package br.com.nova.projeto_nova.controller;

import br.com.nova.projeto_nova.bean.dto.PedidoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.PedidoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Pedido;
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

    @GetMapping("/listAll")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(){
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.listarPedidos(), PedidoResponseDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.getById(id), PedidoResponseDTO.class));
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.criarPedido(pedidoRequestDTO), PedidoResponseDTO.class));
    }

    @PutMapping("/altStatus/{id}")
    public ResponseEntity<PedidoResponseDTO> alterarStatusPedido(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.entidadeParaDTO(pedidoService.alterarStatusPedido(id), PedidoResponseDTO.class));
    }



}
