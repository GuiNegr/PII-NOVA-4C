package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
