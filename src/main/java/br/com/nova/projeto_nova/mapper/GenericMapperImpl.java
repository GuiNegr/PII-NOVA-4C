package br.com.nova.projeto_nova.mapper;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenericMapperImpl implements GenericMapper {

    private final ModelMapper mapper;

    public <T> T entidadeParaDTO(Object entidade, Class<T> dto){
        return mapper.map(entidade, dto);
    }

    public <T> T dtoParaEntidade(Object dto, Class<T> entidade){
        return mapper.map(dto, entidade);
    }

    public <T> List<T> entidadeParaDTO(List<?> entidades, Class<T> dto){
        return entidades.stream().map(entidade -> mapper.map(entidade, dto)).collect(Collectors.toList());
    }
}
