package com.Grupo01.PizzaHUB.Dominio.Servicos;

import org.springframework.stereotype.Service;

import com.Grupo01.PizzaHUB.Dominio.Dados.ClienteRepository;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Cliente;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscaPorCPF(String cpf) {
        Cliente cliente = clienteRepository.buscaPorCPF(cpf);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado para o CPF: " + cpf);
        }
        return cliente;
    }

    public boolean adicionaCliente(Cliente cliente) {
        return clienteRepository.adicionaCliente(cliente);
    }
}
