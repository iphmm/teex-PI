package br.com.SistemaEstoque.dao;

import br.com.SistemaEstoque.factory.Factory;
import java.sql.Connection;
import br.com.SistemaEstoque.model.Produto;
import java.sql.PreparedStatement;

public class ProdutoDAO {

    public void save(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco_custo, preco_venda, codigo_barras, id_categoria, id_fornecedor) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
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
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPrecoCusto());
            pstm.setDouble(4, produto.getPrecoVenda());
            pstm.setString(5, produto.getCodigoBarras());
            pstm.setInt(6, produto.getIdCategoria());
            pstm.setInt(7, produto.getIdFornecedor());

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
