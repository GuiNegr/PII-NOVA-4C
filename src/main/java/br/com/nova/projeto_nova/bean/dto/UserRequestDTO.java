package br.com.nova.projeto_nova.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserRequestDTO {
    private String usuaNmUsuario;
    private String usuaDsEmail;
    private String usuaDsCPF;
    private String usuaDsPassword;
    private String usuaCdGrupo;
    private LocalDateTime usuaDhCadastro;
    private LocalDateTime usuaDhInativo;
}
