package com.Grupo01.PizzaHUB.Dominio.Dados;

import java.util.List;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Produto;

public interface ProdutosRepository {
    Produto recuperaProdutoPorid(long id);
    List<Produto> recuperaProdutosCardapio(long id);
}
