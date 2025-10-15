package com.Grupo01.PizzaHUB.Adaptadores.Apresentacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters.PedidoPresenter;
import com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters.PedidoPresenterUC6;
import com.Grupo01.PizzaHUB.Adaptadores.Apresentacao.Presenters.PedidoStatusPresenter;
import com.Grupo01.PizzaHUB.Aplicacao.AprovaPedidoUC;
import com.Grupo01.PizzaHUB.Aplicacao.CancelaPedidoUC;
import com.Grupo01.PizzaHUB.Aplicacao.ConsultaStatusPedidoUC;
import com.Grupo01.PizzaHUB.Aplicacao.ListaPedidosPorIntervaloUC;
import com.Grupo01.PizzaHUB.Aplicacao.PagarPedidoUC;
import com.Grupo01.PizzaHUB.Aplicacao.Request.PedidoRequest;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoResponse;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoResponseUC6;
import com.Grupo01.PizzaHUB.Aplicacao.Responses.PedidoStatusResponse;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final AprovaPedidoUC aprovaPedidoUC;
    private final ConsultaStatusPedidoUC consultaStatusPedidoUC;
    private final CancelaPedidoUC cancelaPedidoUC;
    private final ListaPedidosPorIntervaloUC listaPedidosPorIntervaloUC;
    private final PagarPedidoUC pagarPedidoUC;

    @Autowired
    public PedidoController(PagarPedidoUC pagarPedidoUC, AprovaPedidoUC aprovaPedidoUC, ConsultaStatusPedidoUC consultaStatusPedidoUC, CancelaPedidoUC cancelaPedidoUC, ListaPedidosPorIntervaloUC listaPedidosPorIntervaloUC) {
        this.aprovaPedidoUC = aprovaPedidoUC;
        this.consultaStatusPedidoUC = consultaStatusPedidoUC;
        this.cancelaPedidoUC = cancelaPedidoUC;
        this.listaPedidosPorIntervaloUC = listaPedidosPorIntervaloUC;
        this.pagarPedidoUC = pagarPedidoUC;
    }

    @PostMapping("/submetePedido")
    @CrossOrigin("*")
    public ResponseEntity<PedidoPresenter> submetePedido(@RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse response = aprovaPedidoUC.executar(pedidoRequest);
        PedidoPresenter presenter = new PedidoPresenter(response);
        return ResponseEntity.ok(presenter);
    }   

    @GetMapping("/status/{id}")
    @CrossOrigin("*")
    public ResponseEntity<PedidoStatusPresenter> consultaStatus(@PathVariable long id) {
        PedidoStatusResponse pedido = consultaStatusPedidoUC.executar(id);
        PedidoStatusPresenter presenter = new PedidoStatusPresenter(pedido.getId(), pedido.getStatus());
        return ResponseEntity.ok(presenter);
    }

    @GetMapping("/cancelaPedido/{id}")
    @CrossOrigin("*")
    public ResponseEntity<PedidoStatusPresenter> cancelaPedido(@PathVariable long id) {
        PedidoStatusResponse pedido = cancelaPedidoUC.executar(id);
        PedidoStatusPresenter presenter = new PedidoStatusPresenter(pedido.getId(), pedido.getStatus());
        return ResponseEntity.ok(presenter);
    }

    @GetMapping("/pedidosEntreguesEntre/{dataInicio}/{dataFinal}")
    @CrossOrigin("*")
    public ResponseEntity<List<PedidoPresenterUC6>> listaPedidosEntreguesEntre(
        @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicio, 
        @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFinal) {

        if (dataInicio.isAfter(dataFinal)) {
            return ResponseEntity.badRequest().build();
        }

        LocalDateTime inicioDoDia = dataInicio.atStartOfDay();
        LocalDateTime fimDoDia = dataFinal.atTime(23, 59, 59);

        List<PedidoResponseUC6> listaPedidos = listaPedidosPorIntervaloUC.listaPedidosEntregueDatas(inicioDoDia, fimDoDia);

        List<PedidoPresenterUC6> pedidosPresenter = listaPedidos.stream()
                .map(p -> new PedidoPresenterUC6(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosPresenter);
    }

    @GetMapping("/pagarPedido/{id}")
    @CrossOrigin("*")
    public ResponseEntity<PedidoStatusPresenter> pagarPedido(@PathVariable long id) {
        PedidoStatusResponse pedido = pagarPedidoUC.executar(id);
        PedidoStatusPresenter presenter = new PedidoStatusPresenter(pedido.getId(), pedido.getStatus());
        return ResponseEntity.ok(presenter);
    }

}

