package br.com.nova.projeto_nova.repository;


import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgProdutoRepository extends JpaRepository<ImgProduto, Long> {
}
