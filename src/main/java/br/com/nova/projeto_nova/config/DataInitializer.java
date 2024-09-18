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
        adm.setUsuaNmUsuario("ADM");
        adm.setUsuaDsEmail("adm@gmail.com");
        adm.setUsuaDsPassword("adm123");
        adm.setUsuaDsCPF("720.455.910-00");
        adm.setUsuaCdGrupo("Administrador");

        UserRequestDTO userRequestDTO = mapper.entidadeParaDTO(adm, UserRequestDTO.class);
        userService.create(userRequestDTO);

    }
}