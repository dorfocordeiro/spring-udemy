package io.github.dorfocordeiro.produtos_api.controller;


import io.github.dorfocordeiro.produtos_api.model.Produto;
import io.github.dorfocordeiro.produtos_api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

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
}
