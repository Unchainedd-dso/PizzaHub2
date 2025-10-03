package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.Pedido;

public interface PedidoRepository {
    Pedido criaPedido (Pedido pedido);
    boolean atualiza (Pedido pedido);
    int quantidadePedidosUltimos20Dias(String clienteCpf);
    Pedido mudaStatus (long pedidoId, Pedido.Status status);
}