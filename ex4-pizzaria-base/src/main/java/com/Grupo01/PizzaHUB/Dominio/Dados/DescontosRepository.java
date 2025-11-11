package com.Grupo01.PizzaHUB.Dominio.Dados;
import java.util.List;

import com.Grupo01.PizzaHUB.Dominio.Entidades.Desconto;

public interface DescontosRepository {
    // Para ser usado no UC em que o usuário MASTER requisita todos os decontos disponíveis
    List<Desconto> listaTodos();
    // Para ser usado no UC em que o usuário MASTER seta qual desconto vai ser o ativo no momento
    // Por enquanto, apenas um desconto pode estar ativo por vez
    boolean decideDescontoAtivo(int id);
    // Retorna a percentagem do desconto que está ativo no momento
    double percentagemDesconto(String nome_desconto);
    // Retorna o desconto inteiro que está ativo no momento
    Desconto retornaDescontoAtivo();

}
