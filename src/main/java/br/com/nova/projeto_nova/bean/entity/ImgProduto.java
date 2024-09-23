package br.com.nova.projeto_nova.bean.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

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
        private Produto fkIdproduto;

        @Column(name="NOMEARQUIVO_IMG_NM_PROD", nullable = false, length = 60000)
        private String nomeArquivos;

        @Lob
        @Column(name="BYTES_IMG_NM_PROD", nullable = false, length = 60000)
        private String imgBlob;

        @Column(name="PRINCIPAL_IMG_NM_PROD",nullable = false)
        private boolean imgPrincipal;
}