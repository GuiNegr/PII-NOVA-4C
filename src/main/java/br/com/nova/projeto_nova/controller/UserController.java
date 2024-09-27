package br.com.nova.projeto_nova.controller;

import br.com.nova.projeto_nova.bean.dto.UserRequestDTO;
import br.com.nova.projeto_nova.bean.dto.UserResponseDTO;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final GenericMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.entidadeParaDTO(userService.getById(id), UserResponseDTO.class));
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(mapper.entidadeParaDTO(userService.getAll(), UserResponseDTO.class));
    }

    @GetMapping("/listUsers/ordenada")
    public ResponseEntity<List<UserResponseDTO>> getAllOrdened() {
        return ResponseEntity.ok(mapper.entidadeParaDTO(userService.getAllOrdened(), UserResponseDTO.class));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = mapper.entidadeParaDTO(userService.login(userRequestDTO), UserResponseDTO.class);
        return ResponseEntity.ok().body(userResponseDTO.getUsuaCdGrupo());
    }




    @PutMapping("/inabilitar/{id}")
    public ResponseEntity<UserResponseDTO> inabilitar(@PathVariable("id") Long id) {
        UserResponseDTO userResponseDTO = mapper.entidadeParaDTO(userService.updateInativo(id), UserResponseDTO.class);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO userRequestDTO, @PathVariable("id") Long id) {
        UserResponseDTO userResponseDTO = mapper.entidadeParaDTO(userService.update(userRequestDTO, id), UserResponseDTO.class);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = mapper.entidadeParaDTO(userService.create(userRequestDTO), UserResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

}
