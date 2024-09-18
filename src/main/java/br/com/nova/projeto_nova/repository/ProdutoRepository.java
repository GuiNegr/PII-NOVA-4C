package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;
=======
import java.util.List;
>>>>>>> b337eca (Listagem de produtos)


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
<<<<<<< HEAD
    Optional<Produto> findBynomeProduto(String nomeProd);
=======
    List<Produto> findAllByOrderByIdProdutoDesc();
>>>>>>> b337eca (Listagem de produtos)
}
