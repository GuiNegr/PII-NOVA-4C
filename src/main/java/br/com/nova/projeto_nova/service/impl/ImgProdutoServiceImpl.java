package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.ImgProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import br.com.nova.projeto_nova.bean.entity.Produto;
import br.com.nova.projeto_nova.mapper.GenericMapperImpl;
import br.com.nova.projeto_nova.repository.ImgProdutoRepository;
import br.com.nova.projeto_nova.repository.ProdutoRepository;
import br.com.nova.projeto_nova.service.ImgProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
