package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.ItensPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
}
