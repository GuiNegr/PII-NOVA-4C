package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ImgProdutoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import br.com.nova.projeto_nova.bean.entity.Produto;
import br.com.nova.projeto_nova.mapper.GenericMapperImpl;
import br.com.nova.projeto_nova.repository.ImgProdutoRepository;
import br.com.nova.projeto_nova.repository.ProdutoRepository;
import br.com.nova.projeto_nova.service.ImgProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@Service
public  class ImgProdutoServiceImpl implements ImgProdutoService{

    @Autowired
    private ImgProdutoRepository imgProdutoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private final GenericMapperImpl mapper;

    @Override
    public ImgProduto create(ImgProdutoRequestDTO imgProdutoRequestDTO) {
            return this.imgProdutoRepository.save(mapper.dtoParaEntidade(imgProdutoRequestDTO,ImgProduto.class));
    }

    @Override
    public List<ImgProduto> vizualizarImgs(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        return imgProdutoRepository.findByFkIdproduto(produto);
    }


    @Override
    public List<ImgProdutoResponseDTO> adicionaImgNobanco(List<MultipartFile> imgs,
    List<Boolean> imgPrincipals,List<Long> ids
    ){
        List<ImgProdutoResponseDTO> responseList = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            Long id = ids.get(i);
            ImgProduto imgS = new ImgProduto();
            imgS.setFkIdproduto(produtoRepository.findById(id).orElseThrow());
            try {
                byte[] imgBytes = imgs.get(i).getBytes();
                String imgBase64 = Base64.getEncoder().encodeToString(imgBytes);
                imgS.setImgBlob(imgBase64);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            imgS.setNomeArquivos(imgs.get(i).getOriginalFilename());
            imgS.setImgPrincipal(imgPrincipals.get(i));
            create(mapper.entidadeParaDTO(imgS,ImgProdutoRequestDTO.class));
            responseList.add(mapper.entidadeParaDTO(imgS,ImgProdutoResponseDTO.class));
        }
        return responseList;
    }

    @Override
    public ImgProduto apenasUmaImg(Long id) {
        return imgProdutoRepository.findById(id).orElseThrow();
    }
}
