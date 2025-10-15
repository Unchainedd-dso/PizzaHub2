package com.Grupo01.PizzaHUB.Dominio.Dados;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Cliente;

public interface ClienteRepository {

    boolean adicionaCliente(Cliente cliente);
    Cliente buscaPorCPF(String CPF);

    
}
