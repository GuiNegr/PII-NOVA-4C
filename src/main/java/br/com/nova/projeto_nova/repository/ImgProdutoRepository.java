package br.com.nova.projeto_nova.repository;


import br.com.nova.projeto_nova.bean.dto.ImgProdutoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.ImgProduto;
import br.com.nova.projeto_nova.bean.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgProdutoRepository extends JpaRepository<ImgProduto, Long> {

    List<ImgProduto> findByFkIdproduto(Produto produto);
}
