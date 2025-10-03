package com.bcopstein.ex4_lancheriaddd_v1.Aplicacao;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos.PedidoService;

public class AprovaPedidoUC{
    private PedidoService pedidoService;

    @Autowired
    public AprovaPedidoUC (PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }
}