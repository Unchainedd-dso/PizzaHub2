package com.bcopstein.ex4_lancheriaddd_v1.Dominio.Servicos;

import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.PedidoRepository;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.ItemPedido;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Entidades.Pedido;
import com.bcopstein.ex4_lancheriaddd_v1.Dominio.Dados.ItensEstoqueRepository;

@Service
public class PedidoService{
    private PedidoRepository pedidoRepository;
    private ItensEstoqueRepository itensEstoqueRepository;

    @Autowired
    public PedidoService (PedidoRepository pedidoRepository, ItensEstoqueRepository itensEstoqueRepository){
        this.pedidoRepository = pedidoRepository;
        this.itensEstoqueRepository = itensEstoqueRepository;
    }

    public Pedido criaPedido (Pedido pedido){
        return pedidoRepository.criaPedido(pedido);
    }

    public Pedido aprovaPedido (Pedido pedido){

    }

    public List<Item> verificaItens (Pedido pedido){
        List <Item> itensEmFalta = new ArrayList<>();

        for (ItemPedido itemPedido : pedido.getItens()) {
            Produto produto = item.getProduto();
            Receita receita = produto.getReceita();

            for (Ingrediente ingrediente : receita.getIngredientes()) {
                int quantidadeNecessaria = itemPedido.getQuantidade(); 
                int quantidadeEstoque = itensEstoqueRepository.getQuantidade(ingrediente.getId());

                if (quantidadeEstoque < quantidadeNecessaria) {
                    itensEmFalta.add(itemPedido);
                }
            }
        }

        return itensEmFalta;
    }

    public int calculaCusto (Pedido pedido){
        double valor = 0;
        for (ItemPedido itemPedido : pedido.getItens()) {
            valor += itemPedido.getItem().getPreco() * itemPedido.getItem().getQuantidade();
        }

        double valorCobrado = valor;

        if (pedidoRepository.quantidadePedidosUltimos20Dias(pedido.getCliente().getCpf()) >= 3){
            valorCobrado *= 0.93;
        }

        valorCobrado += valorCobrado * 0.10;

        return valorCobrado;
    }

}