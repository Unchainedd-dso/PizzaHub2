package com.Grupo01.PizzaHUB.Dominio.Servicos;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Cliente;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;

public interface DescontoConcretoI {
    public double aplicarDesconto(Cliente cliente, Pedido pedido, double percentualDesconto);
    public String getNome();
}
