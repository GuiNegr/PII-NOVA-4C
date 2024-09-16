package br.com.nova.projeto_nova.controller;

import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ProdutoResponseDTO;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto/")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Autowired
    private final GenericMapper mapper;


    @PostMapping
    public ResponseEntity<ProdutoResponseDTO>create(@RequestBody ProdutoRequestDTO produtoRequestDTO){
        ProdutoResponseDTO produtoResponseDTO = mapper.entidadeParaDTO(produtoService.createProduto(produtoRequestDTO), ProdutoResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDTO);
    }
}
