package br.com.nova.projeto_nova.controller;


import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ImgProdutoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import br.com.nova.projeto_nova.mapper.GenericMapperImpl;
import br.com.nova.projeto_nova.service.impl.ImgProdutoServiceImpl;
import br.com.nova.projeto_nova.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imgProduto/")
public class ImgProdutoController {

    @Autowired
    private ImgProdutoServiceImpl imgProdutoService;
    @Autowired
    private final GenericMapperImpl mapper;

    @Autowired
    private final ProdutoServiceImpl produtoService;

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<List<ImgProdutoResponseDTO>>create(
            @RequestParam("imgBlob") List<MultipartFile> imgs,
            @RequestParam("imgPrincipal") List<Boolean> imgPrincipals,
            @RequestParam("id") List<Long> ids){
        List<ImgProdutoResponseDTO> responseList = this.imgProdutoService.adicionaImgNobanco(imgs,imgPrincipals,ids);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ImgProdutoResponseDTO>>localizar(@PathVariable Long id){
        List<ImgProdutoResponseDTO> responseList = new ArrayList<>();
        System.out.println(String.valueOf(id));
        responseList = mapper.entidadeParaDTO(imgProdutoService.vizualizarImgs(id),ImgProdutoResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

    @GetMapping("/umaImg/{id}")
    public ResponseEntity<ImgProdutoResponseDTO>localizarUmaImg(@PathVariable Long id){

        ImgProdutoResponseDTO imgProdutoResponseDTO = mapper.entidadeParaDTO(imgProdutoService.apenasUmaImg(id),ImgProdutoResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(imgProdutoResponseDTO);
    }

}
