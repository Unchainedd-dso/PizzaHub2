package com.Grupo01.PizzaHUB.Dominio.Dados;

import java.util.List;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Ingrediente;

public interface IngredientesRepository {
    List<Ingrediente> recuperaTodos();
    List<Ingrediente> recuperaIngredientesReceita(long id);
}
