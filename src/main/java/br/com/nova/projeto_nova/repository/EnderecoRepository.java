package br.com.nova.projeto_nova.repository;

import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    List<Endereco> findByFkUser(User user);
}
