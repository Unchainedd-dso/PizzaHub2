package com.Grupo01.PizzaHUB.Dominio.Servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Cliente;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;

@Service
public class DescontoFrequencia implements DescontoConcretoI{
    private final PedidoService pedidoService;
    private final String nome;

    @Autowired
    public DescontoFrequencia(PedidoService pedidoService){
        this.pedidoService = pedidoService;
        this.nome = "DESCONTO_FIDELIDADE";
    }

    @Override
    public double aplicarDesconto(Cliente cliente, Pedido pedido, double percentagem_desconto) {
        double frequencia20Dias = this.pedidoService.quantidadePedidosUltimos20Dias(cliente.getCpf());
        double valorPedido = pedido.getValor();
        // Trata o erro mais comum
        if (valorPedido < 0) {
            throw new IllegalArgumentException("Valor base inválido para cálculo de desconto.");
        }
        if (frequencia20Dias >= 3) {
            return valorPedido * (1 - percentagem_desconto);
        }
        else{
            return valorPedido;
        }
    }

    public String getNome() {
        return nome;
    }

    
}

