package br.com.nova.projeto_nova.service.impl;
import br.com.nova.projeto_nova.bean.dto.ProdutoRequestDTO;
import br.com.nova.projeto_nova.bean.dto.ProdutoResponseDTO;
import br.com.nova.projeto_nova.bean.entity.Produto;
import br.com.nova.projeto_nova.mapper.GenericMapper;
import br.com.nova.projeto_nova.repository.ProdutoRepository;
import br.com.nova.projeto_nova.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private final GenericMapper mapper;

    @Override
    public Produto getIdProduto(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.orElseThrow();
    }

    @Override
    public Produto createProduto(ProdutoRequestDTO produtoRequestDTO) {
        if(validaDuplicidadeProduto(produtoRequestDTO.getNomeProduto()) != null){
            return null;
        }
        return this.produtoRepository.save(mapper.dtoParaEntidade(produtoRequestDTO, Produto.class));
    }

    @Override
    public Produto alterarStatus(Long id) {
        ProdutoRequestDTO produtoRequestDTO = mapper.entidadeParaDTO(this.produtoRepository.getReferenceById(id), ProdutoRequestDTO.class);
        if(produtoRequestDTO.getProdDhInativo() != null){
            produtoRequestDTO.setProdDhInativo(null);
            return this.produtoRepository.save(mapper.dtoParaEntidade(produtoRequestDTO, Produto.class));
        }
        produtoRequestDTO.setProdDhInativo(LocalDateTime.now());
        return this.produtoRepository.save(mapper.dtoParaEntidade(produtoRequestDTO,Produto.class));
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAllByOrderByIdProdutoDesc();
    }

    public String validaDuplicidadeProduto(String nomeProduto) {
       Produto produto = this.produtoRepository.findBynomeProduto(nomeProduto).orElseThrow();
        if (produto != null) {
            return "Já existe este produto no banco!";
        }
        return null;
    }

    public Produto trocaQtd(Long id, int qtd){
        Produto produto = this.produtoRepository.findById(id).orElseThrow();
        if(produto != null){
            produto.setQtdEstoqueProduto(qtd);
            this.produtoRepository.save(produto);
        }
        return produto;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAllByOrderByIdProdutoDesc();
    }
}
