package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Apresentacao;

@RestController
public class PedidoController {
    private AprovaPedidoUC aprovaPedidoUC;
    
    public PedidoController (AprovaPedidoUC aprovaPedidoUC)
    {
        this.aprovaPedidoUC = aprovaPedidoUC;
    }



    @PostMapping("/submetePedido")
    @CrossOrigin("*")
    public ResponseEntity<PedidoPresenter> submeteAprovação(@RequestBody PedidoResponse pedidoResponse)
    {

        return ResponseEntity<PedidoPresenter> pedidoPresenter;
    }

}