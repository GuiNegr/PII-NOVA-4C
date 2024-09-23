package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;

import java.util.List;

public interface ImgProdutoService{
    public ImgProduto create(ImgProdutoRequestDTO imgProdutoRequestDTO);

    public List<ImgProduto> vizualizarImgs(Long id);
}
