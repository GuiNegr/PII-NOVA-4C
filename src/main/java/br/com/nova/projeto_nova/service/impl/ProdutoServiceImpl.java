package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Produto;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.ProdutoRepository;
import br.com.nova.projeto_nova.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private final GenericMapper mapper;

    @Override
    public Produto getIdProduto(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.orElseThrow();
    }

    @Override
    public Produto createProduto(ProdutoRequestDTO produtoRequestDTO) {
        return this.produtoRepository.save(mapper.dtoParaEntidade(produtoRequestDTO, Produto.class));
    }
}
