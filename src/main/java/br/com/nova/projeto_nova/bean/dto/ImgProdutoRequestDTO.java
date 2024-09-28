package br.com.nova.projeto_nova.bean.dto;

import br.com.nova.projeto_nova.bean.entity.Produto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ImgProdutoRequestDTO {
    private Long fkIdproduto;
    private String imgBlob;
    private String nomeArquivos;
    private boolean imgPrincipal;
}