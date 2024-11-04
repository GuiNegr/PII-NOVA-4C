package br.com.nova.projeto_nova.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class CarrinhoRequestDTO {
    private Long idUser;
    private List<ItensCarrinhoRequestDTO> itensCarrinho;
}
