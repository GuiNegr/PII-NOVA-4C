package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value="SELECT CURRENT_TIMESTAMP() AS DATA", nativeQuery = true)
    LocalDateTime getDate();
}
