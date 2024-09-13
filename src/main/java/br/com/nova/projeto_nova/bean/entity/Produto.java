package br.com.nova.projeto_nova.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

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

    @Column(name = "NOME_PROD_NM_PRODUTO",nullable = false)
    private String nomeProduto;

    @Column(name = "DESC_PROD_NM_PRODUTO", nullable = false)
    private String descDetalhadaProduto;

    @Column(name = "PRECO_PROD_PRODUTO", nullable = false)
    private double precoProduto;

    @Column(name="QTD_PROD_PRODUTO", nullable = false)
    private int qtdEstoqueProduto;

    @Column(name="AVAL_PROD_PRODUTO",nullable = false)
    private Double avalProduto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ID_PROD_CD_PRODUTO")
    private ArrayList<ImgProduto> listaImg;
}
