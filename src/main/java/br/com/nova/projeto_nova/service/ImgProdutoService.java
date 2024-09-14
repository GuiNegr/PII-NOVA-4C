package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;

public interface ImgProdutoService{
    public ImgProduto create(ImgProdutoRequestDTO imgProdutoRequestDTO);
}
