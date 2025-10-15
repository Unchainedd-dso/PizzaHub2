package com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Pedido;

public class PedidoStatusPresenter {
    private long id;
    
    private Pedido.Status status;

    public PedidoStatusPresenter(long id, Pedido.Status status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Pedido.Status getStatus() {
        return status;
    }
}
