package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.EnderecoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.EnderecoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.exception.NotFoundException;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.EnderecoRepository;
import br.com.nova.projeto_nova.repository.UserRepository;
import br.com.nova.projeto_nova.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private GenericMapper  mapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public EnderecoResponseDTO cadastrarUmEndereco(EnderecoRequestDTO enderecoRequestDTO, Long id) {
        Endereco endereco = mapper.entidadeParaDTO(enderecoRequestDTO, Endereco.class);
        endereco.setFkUser(userRepository.findById(id).orElseThrow());
        enderecoRepository.save(endereco);
        return mapper.entidadeParaDTO(endereco, EnderecoResponseDTO.class);
    }

    @Override
    public List<EnderecoResponseDTO> cadastroEndereco(List<Endereco> endereco, User user) {
        List<EnderecoResponseDTO> enderecos = new ArrayList<>();
        for (int i = 0; i < endereco.size() ; i++) {
            Endereco enderecoSave = endereco.get(i);
            enderecoSave.setFkUser(user);
            enderecos.add(mapper.entidadeParaDTO(enderecoRepository.save(enderecoSave),EnderecoResponseDTO.class));
        }
        return enderecos;
    }

    @Override
    public Endereco atualizaCadEndereco(Endereco endereco) {
        Endereco enderecoAntigo = enderecoRepository.findById(endereco.getId()).get();
        enderecoAntigo.setGrupo(endereco.getGrupo());
        enderecoAntigo.setCidade(endereco.getCidade());
        enderecoAntigo.setUf(endereco.getUf());
        enderecoAntigo.setBairro(endereco.getBairro());
        enderecoAntigo.setNumero(endereco.getNumero());
        enderecoAntigo.setComplemento(endereco.getComplemento());
        enderecoAntigo.setEnderecoPrincipal(endereco.isEnderecoPrincipal());
        return enderecoRepository.save(enderecoAntigo);
    }

    @Override
    public List<EnderecoResponseDTO> listarEndereco(User user) {
        List<EnderecoResponseDTO> enderecoResponseDTOS = new ArrayList<>();
        List<Endereco> enderecos = enderecoRepository.findByFkUser(user);
        for (int i = 0; i < enderecos.size(); i++) {
            EnderecoResponseDTO enderecoResponseDTO = mapper.entidadeParaDTO(enderecos.get(i),EnderecoResponseDTO.class);
            enderecoResponseDTOS.add(enderecoResponseDTO);
        }
        return enderecoResponseDTOS;
    }

    @Override
    public EnderecoResponseDTO buscarUmEndereco(Long idendereco) {
        return mapper.entidadeParaDTO(enderecoRepository.findById(idendereco),EnderecoResponseDTO.class);
    }
}
