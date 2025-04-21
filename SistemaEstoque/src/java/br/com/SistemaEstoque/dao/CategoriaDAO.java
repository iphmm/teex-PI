package br.com.SistemaEstoque.dao;

import br.com.SistemaEstoque.factory.Factory;
import java.sql.Connection;
import br.com.SistemaEstoque.model.Categoria;
import java.sql.PreparedStatement;
/**
 *
 * @author paulo
 */
public class CategoriaDAO {
    public void save(Categoria categoria){
        String sql = "INSERT INTO categoria (nome, descricao) " +
                     "VALUES (?, ?)";
        
    Connection conexao = null;
    PreparedStatement pstm = null;
    try{
            // Cria a conexão com o banco
            conexao = Factory.getConnection();
            
            // Desabilita auto-commit para garantir a inserção
            conexao.setAutoCommit(false);

            // Criação da PreparedStatement para a execução da query
            pstm = conexao.prepareStatement(sql);
            
            // Adiciona os valores esperados pela Query
            pstm.setString(1, categoria.getNome());
            pstm.setString(2, categoria.getDescricao());
            
             // Executar a query
            int rowsAffected = pstm.executeUpdate(); // Execute update para INSERT

            // Se a inserção foi bem-sucedida, faz o commit
            if (rowsAffected > 0) {
                conexao.commit();
                System.out.println("Categoria inserida com sucesso!");
            } else {
                System.out.println("Nenhum dado foi inserido.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // Volta em caso de erro
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
    
    
public List<categoria> getCategoria(){
    
    
}
}
