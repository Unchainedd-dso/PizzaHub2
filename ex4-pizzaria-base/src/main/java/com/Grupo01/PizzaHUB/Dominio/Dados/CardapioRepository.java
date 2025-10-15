package com.Grupo01.PizzaHUB.Dominio.Dados;

import java.util.List;

import com.Grupo01.PizzaHUB.Dominio.Entidades.CabecalhoCardapio;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Cardapio;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Produto;

public interface CardapioRepository {
    List<CabecalhoCardapio> cardapiosDisponiveis();
    Cardapio recuperaPorId(long id);
    List<Produto> indicacoesDoChef();
}
