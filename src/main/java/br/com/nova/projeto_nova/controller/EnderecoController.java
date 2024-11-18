package br.com.nova.projeto_nova.controller;


import br.com.nova.projeto_nova.bean.dto.EnderecoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.EnderecoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.service.EnderecoService;
import br.com.nova.projeto_nova.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UserService userService;

    @Autowired
    private GenericMapper genericMapper;

    @PostMapping("/{id}")
    public ResponseEntity<List<EnderecoResponseDTO>> salvarEndereco(@RequestBody List<EnderecoRequestDTO> endereco,@PathVariable("id") long id){
      List <EnderecoResponseDTO> enderecos = enderecoService.cadastroEndereco(genericMapper.entidadeParaDTO(endereco,Endereco.class), userService.getById(id));
      return ResponseEntity.ok().body(enderecos);
    }

    @PostMapping("/adicionarMaisUm/{id}")
    public ResponseEntity<EnderecoResponseDTO> salvarApenasUmEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO, @PathVariable("id") Long id){
        EnderecoResponseDTO enderecoResponseDTO = enderecoService.cadastrarUmEndereco(enderecoRequestDTO,id);
        return ResponseEntity.ok().body(enderecoResponseDTO);
    }

    @GetMapping("/ListarEndereco/{id}")
    public ResponseEntity<List<EnderecoResponseDTO>> listarEndereco(@PathVariable("id")Long id){
        List<EnderecoResponseDTO> endereco = enderecoService.listarEndereco(userService.getById(id));
        return ResponseEntity.ok().body(endereco);
    }

    @PutMapping("/editarEndereco")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@RequestBody Endereco endereco){
        Endereco enderecoResponse = enderecoService.atualizaCadEndereco(endereco);
        return ResponseEntity.ok().body(genericMapper.entidadeParaDTO(enderecoResponse,EnderecoResponseDTO.class));
    }

    @GetMapping("/ListarUmEndereco/{id}")
    public ResponseEntity<EnderecoResponseDTO> listarUmEndereco(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(enderecoService.buscarUmEndereco(id));
    }
}
