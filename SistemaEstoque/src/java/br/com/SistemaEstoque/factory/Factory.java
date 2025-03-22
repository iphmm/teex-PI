package br.com.SistemaEstoque.factory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author paulo
 */
public class Factory {
    //Nome do Usuario
    private static final String USERNAME = "root";
    
    //Senha do banco
    private static final String PASSWORD = "root";
    
    //caminho do Banco de dados, porta, nome do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sistemaestoque";
    
    /*
     *Conexão com o banco
     **/
       
     public static Connection getConnection() throws SQLException, Exception{
         //Faz a classe seja carregada pela JVM
         //Class.forName("com.mysql.jdbc.Driver"); //Versões mais antigas do MySQL
         Class.forName("com.mysql.cj.jdbc.Driver");  // Para versões mais recentes do MySQL
         Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
         return connection;
     }
     
     public static void main(String[] args) throws Exception {
        try (Connection con = getConnection()) {
            if (con != null) {
                System.out.println("Conexão obtida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
