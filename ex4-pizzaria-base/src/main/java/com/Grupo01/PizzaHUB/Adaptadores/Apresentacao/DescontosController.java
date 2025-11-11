package com.Grupo01.PizzaHUB.Adaptadores.Apresentacao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters.CardapioPresenter;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.CardapioResponse;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Produto;

public class DescontosController {
    @GetMapping("/descontos_disponiveis")
    @CrossOrigin("*")
    public DescontosPresenter recuperaCardapio(@PathVariable(value="id")long id){
        
        }
        return cardapioPresenter;
    }
}
