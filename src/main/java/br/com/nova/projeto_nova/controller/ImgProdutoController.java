package br.com.nova.projeto_nova.controller;


import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ImgProdutoResponseDTO;
import br.com.nova.projeto_nova.mapper.GenericMapperImpl;
import br.com.nova.projeto_nova.service.impl.ImgProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imgProduto/")
public class ImgProdutoController {

    @Autowired
    private ImgProdutoServiceImpl imgProdutoService;
    @Autowired
    private final GenericMapperImpl mapper;

    @PostMapping
    public ResponseEntity<ImgProdutoResponseDTO> create(@RequestBody ImgProdutoRequestDTO imgDTO){
        ImgProdutoResponseDTO imgProdutoResponseDTO = mapper.entidadeParaDTO(imgProdutoService.create(imgDTO), ImgProdutoResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(imgProdutoResponseDTO);
    }
}
