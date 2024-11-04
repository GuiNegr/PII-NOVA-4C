package br.com.nova.projeto_nova.bean.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CDTB_CARRINHO_CARR")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARR_CD_CARRINHO")
    private Long idCarrinho;

    @OneToOne
    @JoinColumn(name = "CARR_ID_USER_CD_USUARIO")
    private User idUser;

    @OneToMany(mappedBy = "idCarrinho", cascade = CascadeType.ALL)
    private List<ItensCarrinho> itensCarrinho;


}
