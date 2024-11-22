package br.com.nova.projeto_nova.config;

import br.com.nova.projeto_nova.bean.dto.UserRequestDTO;
import br.com.nova.projeto_nova.bean.entity.User;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {
        User adm = new User();
        User user = new User();
        adm.setUsuaNmUsuario("ADM");
        user.setUsuaNmUsuario("user");
        adm.setUsuaDsEmail("adm@adm.com");
        user.setUsuaDsEmail("user@outlook.com");
        adm.setUsuaDsPassword("adm123");
        user.setUsuaDsPassword("2020");
        adm.setUsuaDsCPF("720.455.910-00");
        user.setUsuaDsCPF("052.003.800-22");
        adm.setUsuaCdGrupo("Administrador");
        user.setUsuaCdGrupo("usuario");

        UserRequestDTO userRequestDTO = mapper.entidadeParaDTO(adm, UserRequestDTO.class);
        UserRequestDTO userRequestDTO2 = mapper.entidadeParaDTO(user, UserRequestDTO.class);
        userService.create(userRequestDTO2);
        userService.create(userRequestDTO);

    }
}