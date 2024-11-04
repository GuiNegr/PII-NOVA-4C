package br.com.nova.projeto_nova.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CDTB_ITENSPEDIDO_ITPD")
public class ItensPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITPD_CD_ITENSPEDIDO")
    private Long idItensPedido;

    @ManyToOne
    @JoinColumn(name = "ITPD_ID_PEDI_CD_PEDIDO")
    @JsonIgnore
    private Pedido idPedido;

    @ManyToOne
    @JoinColumn(name = "ITPD_ID_PROD_CD_PRODUTO")
    private Produto idProduto;

    @Column(name = "ITPD_NM_QUANTIDADE")
    private int quantidade;

    @Column(name = "ITPD_NM_PRECOUNITARIO")
    private Double precoUnitario;

    @Column(name = "ITPD_NM_SUBTOTAL")
    private Double subTotal;


}
