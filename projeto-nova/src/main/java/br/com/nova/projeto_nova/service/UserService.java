package br.com.nova.projeto_nova.service;

import br.com.nova.projeto_nova.bean.dto.UserRequestDTO;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.exception.ConflictException;
import br.com.nova.projeto_nova.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User getById(Long id) throws NotFoundException;
    User getByEmail(String usuarioEmail) throws NotFoundException;
    List<User> getAll();
    List<User> getAllOrdened();
    User create(UserRequestDTO userRequestDTO) throws ConflictException;
    User update(UserRequestDTO userRequestDTO, Long id) throws NotFoundException, ConflictException;
}
