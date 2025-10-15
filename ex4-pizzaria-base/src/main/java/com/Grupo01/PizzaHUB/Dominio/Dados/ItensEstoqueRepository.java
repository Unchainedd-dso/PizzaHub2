package com.Grupo01.PizzaHUB.Dominio.Dados;

public interface ItensEstoqueRepository{
    int getQuantidade (long ingredienteId);
    void atualizaQuantidade (long ingrediente_id, int quantidade);
}