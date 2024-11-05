package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.EnderecoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.EnderecoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.User;

import java.util.List;

public interface EnderecoService {

    EnderecoResponseDTO cadastrarUmEndereco(EnderecoRequestDTO enderecoRequestDTO, Long id);
    List<EnderecoResponseDTO> cadastroEndereco(List<Endereco> endereco, User user);
    Endereco atualizaCadEndereco(Endereco endereco);
    List<EnderecoResponseDTO>listarEndereco(User user);
}
