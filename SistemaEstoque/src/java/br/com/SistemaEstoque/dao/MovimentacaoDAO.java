package br.com.SistemaEstoque.dao;
import br.com.SistemaEstoque.factory.Factory;
import br.com.SistemaEstoque.model.Movimentacao;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author paulo
 */
public class MovimentacaoDAO {
    public void save(Movimentacao movimentacao){
        String sql = "INSERT INTO movimentacao (quantidade, preco_unitario, observacao, id_produto, id_usuario) " +
                     "VALUES (?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;
        
        try {
            // Cria a conexão com o banco
            conexao = Factory.getConnection();
            
            // Desabilita auto-commit para garantir a inserção
            conexao.setAutoCommit(false);

            // Criação da PreparedStatement para a execução da query
            pstm = conexao.prepareStatement(sql);
            
            // Adiciona os valores esperados pela query
            pstm.setInt(1, movimentacao.getQuantidade());
            pstm.setDouble(2, movimentacao.getPrecoUnitario());
            pstm.setString(3, movimentacao.getObservacao());
            pstm.setInt(4, movimentacao.getIdProduto());
            pstm.setInt(5, movimentacao.getIdUsuario());

            // Executar a query
            int rowsAffected = pstm.executeUpdate(); // Execute update para INSERT

            // Se a inserção foi bem-sucedida, faz o commit
            if (rowsAffected > 0) {
                conexao.commit();
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Nenhum dado foi inserido.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback em caso de erro
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            // Fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
