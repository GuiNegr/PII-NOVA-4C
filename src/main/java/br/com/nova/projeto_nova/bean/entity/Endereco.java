package br.com.nova.projeto_nova.bean.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="CDTB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO_NM_ENDERECO")
    private Long id;

    @Column(name = "CEP_ENDERECO_NM_ENDERECO", nullable = false)
    private String cep;

    @Column(name = "LOGRADOURO_NM_ENDERECO", nullable = false)
    private String logradouro;

    @Column(name = "NUMERO_NM_ENDERECO", nullable = false)
    private int numero;

    @Column(name = "COMPLEMENTO_NM_ENDERECO", nullable = true)
    private String complemento;

    @Column(name = "BAIRRO_NM_ENDERECO", nullable = false)
    private String bairro;

    @Column(name = "CIDADE_NM_ENDERECO", nullable = false)
    private String cidade;

    @Column(name= "UF_NM_ENDERECO" , nullable = false)
    private String uf;

    @Column(name = "ENDERECO_PRINCIPAL_NM_ENDERECO")
    private boolean enderecoPrincipal;

    @ManyToOne
    @JoinColumn
    private User fkUser;
}
