package br.com.nova.projeto_nova.bean.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CDTB_PEDIDOS_PEDI")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDI_CD_PEDIDO")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "PEDI_ID_USUA_CD_USUARIO")
    private User idUser;

    @Column(name = "PRODUTOPEDIDO")
    private String nomeProduto;

    @Column(name = "PEDI_DS_STATUSPEDIDO")
    private StatusPedido statusPedido;

    @Column(name = "PEDI_DH_DATAGERACAO")
    private LocalDateTime dataPedido;

    @Column(name = "PEDI_NM_VALORTOTAL")
    private Double valorTotal;

    @Column(name="PEDI_NM_NUMPEDIDO")
    private int numeroPedido;

    @ManyToOne
    @JoinColumn
    private Endereco fkEndereco;


}