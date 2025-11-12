package com.Grupo01.PizzaHUB.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Grupo01.PizzaHUB.Dominio.Servicos.DescontoService;

@Component
public class DecideDescontoAtivoUC {
    private DescontoService descontoService;

    @Autowired
    public DecideDescontoAtivoUC(DescontoService descontoService){
        this.descontoService = descontoService;
    }

    public boolean executar(long id){
        boolean escolhaFeita = descontoService.decideDescontoAtivo(id);
        return escolhaFeita;
    } 
}
