package br.com.nova.projeto_nova.bean.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
@Entity
@Table(name = "CDTB_IMGPROD_IMG")
public class ImgProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_IMG_CD_PROD")
    private long idImgProd;

    @ManyToOne
    @JoinColumn(name = "FK_PROD_CD_PROD")
    private Produto FkIdproduto;

    @Column(name="CAMINHO_IMG_NM_PROD",nullable = false)
    private String caminhoImg;

    @Column(name="PRINCIPAL_IMG_NM_PROD",nullable = false)
    private boolean imgPrincipal;
}
