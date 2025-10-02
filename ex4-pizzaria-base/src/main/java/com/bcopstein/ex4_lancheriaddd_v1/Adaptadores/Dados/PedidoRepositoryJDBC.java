package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Dados;

@Component
public class PedidoRepositoryJDBC implements PedidoRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientesRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pedido criaPedido(Pedido pedido) {
        String sqlPedido = "INSERT INTO pedidos (cliente_cpf, dataHoraPagamento, status_pedido, valor, impostos, desconto, valorCobrado) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sqlPedido,
            pedido.getCliente().getCpf(),
            Timestamp.valueOf(pedido.getDataHoraPagamento()),
            pedido.getStatus().name(),
            pedido.getValor(),
            pedido.getImpostos(),
            pedido.getDesconto(),
            pedido.getValorCobrado()
        );

        // depois de inserir o pedido, você precisaria buscar o id gerado
        // aqui, vou supor que você vai buscar pelo último id (pode variar conforme banco)
        Long pedidoId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM pedidos", Long.class);
        pedido.setId(pedidoId);

        String sqlItem = "INSERT INTO item_pedido (pedido_id, produto_id, quantidade) VALUES (?, ?, ?)";
        for (ItemPedido item : pedido.getItens()) {
            jdbcTemplate.update(sqlItem,
                pedidoId,
                item.getProduto().getId(),
                item.getQuantidade()
            );
        }

        return pedido;
    }

    @Override
    public boolean atualizaPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET " +
                    "status_pedido = ?, " +
                    "valor = ?, " +
                    "impostos = ?, " +
                    "desconto = ?, " +
                    "valorCobrado = ? " +
                    "WHERE id = ?";

        int linhasAfetadas = jdbcTemplate.update(sql,
            pedido.getStatus().name(),
            pedido.getValor(),
            pedido.getImpostos(),
            pedido.getDesconto(),
            pedido.getValorCobrado(),
            pedido.getId()
        );

        return linhasAfetadas > 0;
    }

   @Override
    public boolean mudaStatus(long pedidoId, Pedido.Status status) {
        String sql = "UPDATE pedidos SET status_pedido = ? WHERE id = ?";
        int linhasAfetadas = jdbcTemplate.update(sql, status.name(), pedidoId);
        return linhasAfetadas > 0; // true se atualizou, false se não
    }

    @Override
    public int quantidadePedidosUltimos20Dias(String clienteCpf) {
    String sql = "SELECT COUNT(*) FROM pedidos " +
                 "WHERE cliente_cpf = ? AND dataHoraPagamento >= CURRENT_DATE - INTERVAL '20' DAY";
    
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, clienteCpf);
    return count != null ? count : 0;
}
}