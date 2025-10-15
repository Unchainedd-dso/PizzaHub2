package com.Grupo01.PizzaHUB.Dominio.Dados;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Receita;

public interface ReceitasRepository {
    Receita recuperaReceita(long id);
    
}
