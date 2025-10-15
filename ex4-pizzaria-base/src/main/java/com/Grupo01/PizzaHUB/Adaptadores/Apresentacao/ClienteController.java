package com.Grupo01.PizzaHUB.Adaptadores.Apresentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Cliente;
import com.Grupo01.PizzaHUB.Dominio.Servicos.ClienteService;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/{cpf}")
    public Cliente buscaClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = clienteService.buscaPorCPF(cpf);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado para o CPF: " + cpf);
        }
        return cliente;
    }
}
