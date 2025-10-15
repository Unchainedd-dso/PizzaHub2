package com.Grupo01.PizzaHUB.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo01.PizzaHUB.Aplicacao.Request.PedidoRequest;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoResponse;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoStatusResponse;
import com.Grupo01.PizzaHUB.Dominio.Entidades.ItemPedido;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;
import com.Grupo01.PizzaHUB.Dominio.Servicos.CozinhaService;
import com.Grupo01.PizzaHUB.Dominio.Servicos.PedidoService;

@Component
public class PagarPedidoUC
{
    private PedidoService pedidoService;
    private CozinhaService cozinhaService;

    @Autowired
    public PagarPedidoUC(PedidoService pedidoService, CozinhaService cozinhaService)
    {
        this.pedidoService = pedidoService;
        this.cozinhaService = cozinhaService;
    }

    public PedidoStatusResponse executar(Long id) {
        Pedido pedido = pedidoService.buscaPorId(id);
        pedido.setStatus(Pedido.Status.PAGO);
        pedidoService.atualizaPedido(pedido);

        // Envia para a cozinha e deixa ela cuidar do fluxo (PREPARACAO → PRONTO → SAÍDA)
        cozinhaService.chegadaDePedido(pedido);

        System.out.println("Pedido enviado para a cozinha");

        // Aqui o status final ainda é PAGO, a cozinha vai mudar depois
        return new PedidoStatusResponse(pedido);
    }
}
