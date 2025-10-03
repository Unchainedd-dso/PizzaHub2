package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Apresentacao.Presenters;

public class PedidoPresenter{
    private long id;
    public enum Status {
        NOVO,
        APROVADO,
        PAGO,
        AGUARDANDO,
        PREPARACAO,
        PRONTO,
        TRANSPORTE,
        ENTREGUE
    }
    private Status status;

    public PedidoPresenter (long id, Status status){
        this.id = id;
        this.status = status;
    }

    public getStatus (){
        return this.status;
    }

    public getId (){
        return this.id;
    }
}