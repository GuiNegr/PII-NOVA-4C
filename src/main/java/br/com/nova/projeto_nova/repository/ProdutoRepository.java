package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByOrderByIdProdutoDesc();
}
