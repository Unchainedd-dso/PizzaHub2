package com.bcopstein.ex4_lancheriaddd_v1.Adaptadores.Dados;

@Component
public class ItensEstoqueRepositoryJDBC{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientesRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getQuantidade (long ingredienteId){
        String sql = "SELECT quantidade FROM itensEstoque WHERE ingrediente_id = ?";
        Integer quantidade = jdbcTemplate.queryForObject(sql, new Object[]{ingredienteId}, Integer.class);
        return quantidade != null ? quantidade : 0;
    }
    

    @Override
    public void atualizaQuantidade (long ingrediente_id, int quantidade){
        String sql = "UPDATE itensEstoque SET quantidade = ? WHERE ingrediente_id = ?";
        jdbcTemplate.update(sql, quantidade, ingredienteId);
    }
}