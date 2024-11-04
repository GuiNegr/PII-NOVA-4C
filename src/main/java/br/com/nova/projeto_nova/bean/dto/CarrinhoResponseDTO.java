package br.com.nova.projeto_nova.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoResponseDTO {
    private Long idCarrinho;
    private Long idUser;
    private List<ItensCarrinhoResponseDTO> itensCarrinho;
}
