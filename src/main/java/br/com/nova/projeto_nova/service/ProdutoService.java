package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    Produto getIdProduto(Long id);
    Produto createProduto(ProdutoRequestDTO produtoRequestDTO);
    Produto alterarStatus(Long id);
    List<Produto> listarProdutos();

}
