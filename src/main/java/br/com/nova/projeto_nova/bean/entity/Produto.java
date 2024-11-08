package br.com.nova.projeto_nova.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
@Table(name="CDTB_PRODUTO_PROD")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROD_CD_PRODUTO")
    private Long idProduto;

    @Column(name = "PROD_NM_PRODUTO",nullable = false, length = 200)
    private String nomeProduto;

    @Column(name = "PROD_TX_DESC", nullable = false, length = 2000)
    private String descDetalhadaProduto;

    @Column(name = "PROD_NR_PRECO", nullable = false)
    private BigDecimal precoProduto;

    @Column(name="PROD_NR_QUANTIDADE", nullable = false)
    private int qtdEstoqueProduto;

    @Column(name="PROD_NR_AVAL", nullable = false)
    private Double avalProduto;

    @CreationTimestamp
    @Column(name = "PROD_DH_CADASTRO",nullable = false)
    private LocalDateTime prodDhCadastro;

    @Column(name = "PROD_DH_INATIVO")
    private LocalDateTime prodDhInativo;


    @ManyToOne(optional = false)
    private Pedido pedidos;

}
