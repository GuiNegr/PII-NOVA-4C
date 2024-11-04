package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.CarrinhoRequestDTO;
import br.com.nova.projeto_nova.bean.entity.Carrinho;

public interface CarrinhoService {
    Carrinho criarCarrinho(CarrinhoRequestDTO carrinho);
    Carrinho getCarrinhoById(int id);
}
