package com.Grupo01.PizzaHUB.Aplicacao.Request;

public class ItemPedidoRequest {
    private long produtoId;
    private int quantidade;

    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
