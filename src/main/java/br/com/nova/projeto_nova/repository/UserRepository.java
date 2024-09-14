package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsuaDhInativoIsNull();
    Optional<User> findByUsuaDsEmail(String email);
    List<User> findAllByOrderByUsuaNmUsuarioAsc();
    Optional<User> findByUsuaDsCPF(String cpf);
    Optional<User> findByUsuaDsCPFOrUsuaDsEmail(String cpf, String email);
    @Query(value="SELECT CURRENT_TIMESTAMP() AS DATA", nativeQuery = true)
    LocalDateTime getDate();
}
