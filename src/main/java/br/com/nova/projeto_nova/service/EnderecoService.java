package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.EnderecoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.User;

import java.util.List;

public interface EnderecoService {

    List<EnderecoResponseDTO> cadastroEndereco(List<Endereco> endereco, User user);
    Endereco atualizaCadEndereco(Endereco endereco,Long idUser);
    List<EnderecoResponseDTO>listarEndereco(User user);
}
