package io.github.dorfocordeiro.produtos_api.repository;

import io.github.dorfocordeiro.produtos_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
