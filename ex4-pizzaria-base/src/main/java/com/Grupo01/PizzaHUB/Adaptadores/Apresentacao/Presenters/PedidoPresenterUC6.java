package com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters;

import java.time.LocalDateTime;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoResponseUC6;


public class PedidoPresenterUC6 {
    private long id;
    private String clienteCpf;
    private LocalDateTime dataHoraPagamento;
    private String status;
    private double valorCobrado;

    public PedidoPresenterUC6(PedidoResponseUC6 pedidoResponseUC6) {
        this.id = pedidoResponseUC6.getId();
        this.clienteCpf = pedidoResponseUC6.getClienteCpf();
        this.dataHoraPagamento = pedidoResponseUC6.getDataHoraPagamento();
        this.status = pedidoResponseUC6.getStatus();
        this.valorCobrado = pedidoResponseUC6.getValorCobrado();
    }

    public long getId() {
        return id;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public String getStatus() {
        return status;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }
}