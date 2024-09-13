package br.com.nova.projeto_nova.bean.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "CDTB_USUARIO_USUA")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUA_CD_USUARIO")
    private Long idUsuario;

    @Column(name = "USUA_NM_USUARIO", nullable = false)
    private String usuaNmUsuario;

    @Column(name = "USUA_DS_EMAIL", unique = true, nullable = false)
    private String usuaDsEmail;

    @Column(name = "USUA_DS_PASSWORD", nullable = false)
    private String usuaDsPassword;

    @Column(name = "USUA_DS_CPF", nullable = false)
    private String usuaDsCPF;

    @Column(name = "USUA_CD_GRUPO", nullable = false)
    private String usuaCdGrupo;

    @CreationTimestamp
    @Column(name = "USUA_DH_CADASTRO", nullable = false)
    private LocalDateTime usuaDhCadastro;

    @Column(name = "USUA_DH_INATIVO")
    private LocalDateTime usuaDhInativo;
}
