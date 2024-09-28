package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ImgProdutoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImgProdutoService{
    public ImgProduto create(ImgProdutoRequestDTO imgProdutoRequestDTO);

    public List<ImgProduto> vizualizarImgs(Long id);

    public ImgProduto apenasUmaImg(Long id);

    public List<ImgProdutoResponseDTO> adicionaImgNobanco(List<MultipartFile> imgs, List<Boolean> imgPrincipals,List<Long> ids
    );
}
