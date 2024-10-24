package br.com.nova.projeto_nova.service.impl;

import br.com.nova.projeto_nova.bean.dto.UserRequestDTO;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.exception.ConflictException;
import br.com.nova.projeto_nova.exception.NotFoundException;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.UserRepository;
import br.com.nova.projeto_nova.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    private final Validadores validadores;

    private final GenericMapper mapper;

    @Override
    public User getById(Long id) throws NotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possível encontrar o usuário pelo id " + id));
    }

    @Override
    public User getByEmail(String usuarioEmail) throws NotFoundException {
        return userRepository.findByUsuaDsEmail(usuarioEmail).orElseThrow(() -> new NotFoundException("Não foi possível encontrar o usuário pelo email " + usuarioEmail));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllOrdened() {
        return userRepository.findAllByOrderByUsuaNmUsuarioAsc();
    }

    @Override
    public User login(UserRequestDTO userRequestDTO) {
        User user = null;
        user = userRepository.findByUsuaDsEmail(userRequestDTO.getUsuaDsEmail()).orElseThrow(() -> new NotFoundException("Não foi possível encontrar o usuário pelo email " + userRequestDTO.getUsuaDsEmail()));
        if (!passwordEncoder.matches(userRequestDTO.getUsuaDsPassword(), user.getUsuaDsPassword())) {
            throw new IllegalArgumentException("Email ou senha incorreto!");
        }
        return user;
    }

    @Override
    public User create(UserRequestDTO userRequestDTO) throws ConflictException {
        String mensagem = validaDuplicidadeUsuarioUpdate(userRequestDTO);
        if (mensagem != null) {
            throw new ConflictException(mensagem);
        }

        if(!validadores.validaCpf(userRequestDTO.getUsuaDsCPF())){
            if(userRepository.existsByUsuaDsCPF(userRequestDTO.getUsuaDsCPF())){
                throw new ConflictException("CPF INVALIDO OU JÁ PRESENTE NA NOSSA BASE");
            }
        }

        if(!validadores.validaEmail(userRequestDTO.getUsuaDsEmail())){
            throw new ConflictException("EMAIL INVALIDO");
        }

        String senhaEncryptada = passwordEncoder.encode(userRequestDTO.getUsuaDsPassword());
        userRequestDTO.setUsuaDsPassword(senhaEncryptada);

        if (userRequestDTO.getUsuaCdGrupo() == null) {
            userRequestDTO.setUsuaCdGrupo("Usuário");
        }

        return userRepository.save(mapper.dtoParaEntidade(userRequestDTO, User.class));
    }

    @Override
    public User update(UserRequestDTO userRequestDTO, Long id) throws NotFoundException, ConflictException {
        User user = getById(id);
        String mensagem = validaDuplicidadeUsuarioUpdate(userRequestDTO);
        if (mensagem != null) {
            throw new ConflictException(mensagem);
        }
        if(!passwordEncoder.matches(user.getUsuaDsPassword(), userRequestDTO.getUsuaDsPassword()) && userRequestDTO.getUsuaDsPassword() != null){
            userRequestDTO.setUsuaDsPassword(passwordEncoder.encode(userRequestDTO.getUsuaDsPassword()));
        }else {
            userRequestDTO.setUsuaDsPassword(user.getUsuaDsPassword());
        }
        userRequestDTO.setUsuaNmUsuario(userRequestDTO.getUsuaNmUsuario() != null ? userRequestDTO.getUsuaNmUsuario() : user.getUsuaNmUsuario());
        userRequestDTO.setUsuaDsCPF(userRequestDTO.getUsuaDsCPF() != null ? userRequestDTO.getUsuaDsCPF() : user.getUsuaDsCPF());
        userRequestDTO.setUsuaCdGrupo(userRequestDTO.getUsuaCdGrupo() != null ? userRequestDTO.getUsuaCdGrupo() : user.getUsuaCdGrupo());
        userRequestDTO.setUsuaDsEmail(user.getUsuaDsEmail());
        userRequestDTO.setUsuaDhCadastro(user.getUsuaDhCadastro());
        user = mapper.dtoParaEntidade(userRequestDTO, User.class);
        user.setIdUsuario(id);

        return userRepository.save(user);


    }

    public User updateInativo(Long id) {
        User user = getById(id);
        if (user.getUsuaDhInativo() == null) user.setUsuaDhInativo(userRepository.getDate());
        else user.setUsuaDhInativo(null);
        return userRepository.save(user);
    }

    public String validaDuplicidadeUsuario(UserRequestDTO userRequestDTO) {
        if (userRepository.findByUsuaDsEmail(userRequestDTO.getUsuaDsEmail()).isPresent()) {
            return "Esse email já está cadastrado!";
        }
        return null;
    }

    public String validaDuplicidadeUsuarioUpdate(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByUsuaDsCPFOrUsuaDsEmail(userRequestDTO.getUsuaDsEmail(), userRequestDTO.getUsuaDsCPF()).orElse(null);
        if (user != null) {
            return "Já existe usuário cadastrado com esse email ou CPF!";
        }

        return null;

    }

}
