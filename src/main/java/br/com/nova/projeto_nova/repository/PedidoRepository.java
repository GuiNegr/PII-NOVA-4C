package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Pedido;
import br.com.nova.projeto_nova.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value="SELECT CURRENT_TIMESTAMP() AS DATA", nativeQuery = true)
    LocalDateTime getDate();
    List<Pedido> findByIdUser(User id);
}
