package br.com.nova.projeto_nova.mapper;

import java.util.List;

public interface GenericMapper {

    <T> T entidadeParaDTO(Object entidade, Class<T> dto);
    <T> T dtoParaEntidade(Object dto, Class<T> entidade);
    <T> List<T> entidadeParaDTO(List<?> entidades, Class<T> dto);

}
