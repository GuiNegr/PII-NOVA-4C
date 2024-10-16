package br.com.nova.projeto_nova.controller;


import br.com.nova.projeto_nova.bean.dto.EnderecoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Endereco;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.service.EnderecoService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping
    public ResponseEntity<List<EnderecoResponseDTO>> salvarEndereco(@RequestParam("enderecos") List<Endereco> endereco, @RequestParam("user") User user){
      List <EnderecoResponseDTO> enderecos = enderecoService.cadastroEndereco(endereco, user);
      return ResponseEntity.ok().body(enderecos);
    }

    @GetMapping("/ListarEndereco")
    public ResponseEntity<List<EnderecoResponseDTO>> listarEndereco(@RequestBody User User){
        List<EnderecoResponseDTO> endereco = enderecoService.listarEndereco(User);
        return ResponseEntity.ok().body(endereco);
    }
}
