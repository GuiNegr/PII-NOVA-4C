package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Produto;

import java.util.Optional;

public interface ProdutoService {
    public Produto getIdProduto(Long id);
    public Produto createProduto(ProdutoRequestDTO produtoRequestDTO);
    public Produto alterarStatus(Long id);

}
