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
        List<ImgProdutoResponseDTO> responseList = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            Long id = ids.get(i);
            ImgProduto imgS = new ImgProduto();
            imgS.setFkIdproduto(produtoService.getIdProduto(id));
            try {
                imgS.setImgBlob(imgs.get(i).getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            imgS.setNomeArquivos(imgs.get(i).getOriginalFilename());
            imgS.setImgPrincipal(imgPrincipals.get(i));
            imgProdutoService.create(mapper.entidadeParaDTO(imgS,ImgProdutoRequestDTO.class));
            responseList.add(mapper.entidadeParaDTO(imgS,ImgProdutoResponseDTO.class));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ImgProdutoResponseDTO>>localizar(@PathVariable Long id){
        List<ImgProdutoResponseDTO> responseList = new ArrayList<>();
        responseList = mapper.entidadeParaDTO(imgProdutoService.vizualizarImgs(id),ImgProdutoResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }
}
