package br.com.SistemaEstoque.dao;
import br.com.SistemaEstoque.factory.Factory;
import br.com.SistemaEstoque.model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.Connection;
/**
 *
 * @author paulo
 */
public class FornecedorDAO {
    public void save(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone, email) " +
                     "VALUES (?, ?, ?, ?)";
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
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getCnpj());
            pstm.setString(3, fornecedor.getTelefone());
            pstm.setString(4, fornecedor.getEmail());
            
             // Executar a query
            int rowsAffected = pstm.executeUpdate(); // Execute update para INSERT

            // Se a inserção funcionou, faz o commit
            if (rowsAffected > 0) {
                conexao.commit();
                System.out.println("Fornecedor homologado com sucesso!");
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
}
