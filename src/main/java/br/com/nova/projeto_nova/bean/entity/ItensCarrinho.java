package br.com.nova.projeto_nova.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CDTB_ITENSCARRINHO_ITCA")
public class ItensCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITCA_CD_ITENSCARRINHO")
    private Long idItensCarrinho;

    @ManyToOne
    @JoinColumn(name = "ITCA_ID_CARR_CD_CARRINHO")
    @JsonIgnore
    private Carrinho idCarrinho;

    @ManyToOne
    @JoinColumn(name = "ITCA_ID_PROD_CD_PRODUTO")
    private Produto idProduto;

    @Column(name = "ITCA_NM_QUANTIDADE")
    private int quantidade;

    @Column(name = "ITCA_NM_PRECOUNITARIO")
    private Double precoUnitario;

    @Column(name = "ITCA_NM_SUBTOTAL")
    private Double subTotal;

}
