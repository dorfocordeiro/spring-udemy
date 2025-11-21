package io.github.dorfocordeiro.produtos_api.controller;


import io.github.dorfocordeiro.produtos_api.model.Produto;
import io.github.dorfocordeiro.produtos_api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        System.out.println("Salvando produto: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }


    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null; isPresent() -> se estiver presente ? true, : false

//        Usar o Optional para evitar o NullPointerException

        return produtoRepository.findById(id).orElse(null); // Méthodo orElse -> se não encontrar, retorna null
    }


    @DeleteMapping("/{id}")
    public void deletarProdutoPorId(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping
    public List<Produto> obterProdutoPorNome(@RequestParam("nome") String nome) {
         return produtoRepository.findByNome(nome);

    }
}
