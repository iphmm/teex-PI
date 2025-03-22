
package br.com.SistemaEstoque.dao;
import br.com.SistemaEstoque.factory.Factory;
import br.com.SistemaEstoque.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
/**
 *
 * @author paulo
 */
public class UsuarioDAO {
    public void save(Usuario usuario){
        String sql = "INSERT INTO usuario (nome, email, senha_hash, perfil, status_usuario) " +
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
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenhaHash());
            pstm.setString(4, usuario.getPerfil());
            pstm.setBoolean(5, usuario.isStatusUsuario());

            // Executar a query
            int rowsAffected = pstm.executeUpdate(); // Execute update para INSERT

            // Se a inserção foi bem-sucedida, faz o commit
            if (rowsAffected > 0) {
                conexao.commit();
                System.out.println("Usuario Cadastrado com sucesso!");
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
