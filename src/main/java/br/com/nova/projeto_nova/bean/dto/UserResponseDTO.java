package br.com.nova.projeto_nova.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long idUsuario;
    private String usuaNmUsuario;
    private String usuaDsEmail;
    private String usuaDsCPF;
    private String usuaDsPassword;
    private String usuaCdGrupo;
    private LocalDateTime usuaDhCadastro;
    private LocalDateTime usuaDhInativo;
}
