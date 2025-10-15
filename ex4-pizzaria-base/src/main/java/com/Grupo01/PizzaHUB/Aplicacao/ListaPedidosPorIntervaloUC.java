package com.Grupo01.PizzaHUB.Aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoResponseUC6;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;
import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido.Status;
import com.Grupo01.PizzaHUB.Dominio.Servicos.PedidoService;

@Component
public class ListaPedidosPorIntervaloUC{
    private PedidoService pedidoService;

    @Autowired
    public ListaPedidosPorIntervaloUC (PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    public List<PedidoResponseUC6> listaPedidosEntregueDatas(LocalDateTime dataInicio, LocalDateTime dataFinal){
        List<Pedido> pedidos = pedidoService.listaPedidosEntreDatas(dataInicio, dataFinal);

        List<PedidoResponseUC6> pedidosResponse = pedidos.stream()
                .filter(p -> p.getStatus() == Status.ENTREGUE)
                .map(p -> new PedidoResponseUC6(p))
                .collect(Collectors.toList());

        return pedidosResponse;
    }
}