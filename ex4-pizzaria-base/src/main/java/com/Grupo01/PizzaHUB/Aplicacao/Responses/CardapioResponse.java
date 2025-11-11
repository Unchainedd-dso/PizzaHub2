package com.Grupo01.PizzaHUB.Aplicacao.Responses;

import java.util.List;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Cardapio;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Produto;

public class CardapioResponse {
    private Cardapio cardapio;
    private List<Produto> sugestoesDoChef;
    
    public CardapioResponse(Cardapio cardapio, List<Produto> sugestoesDoChef) {
        this.cardapio = cardapio;
        this.sugestoesDoChef = sugestoesDoChef;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public List<Produto> getSugestoesDoChef() {
        return sugestoesDoChef;
    }
}
