package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
