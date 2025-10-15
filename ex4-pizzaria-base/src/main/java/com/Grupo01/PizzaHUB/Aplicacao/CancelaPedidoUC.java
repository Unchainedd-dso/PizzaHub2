package com.Grupo01.PizzaHUB.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoStatusResponse;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;
import com.Grupo01.PizzaHUB.Dominio.Servicos.PedidoService;

@Component
public class CancelaPedidoUC{
    private final PedidoService pedidoService;

    @Autowired
    public CancelaPedidoUC(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public PedidoStatusResponse executar(long idPedido) {
        Pedido pedido = pedidoService.CancelaPedido(idPedido);

        if (pedido == null) {
            throw new RuntimeException("Pedido não encontrado!");
        }

        return new PedidoStatusResponse(pedido);
    }
}

