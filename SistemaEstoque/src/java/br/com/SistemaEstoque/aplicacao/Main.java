package br.com.SistemaEstoque.aplicacao;
/** import Teste Fornecedor
import br.com.SistemaEstoque.dao.FornecedorDAO;
import br.com.SistemaEstoque.model.Fornecedor;
*/


/** import do Teste Usuario
    import br.com.SistemaEstoque.dao.UsuarioDAO;
    import br.com.SistemaEstoque.model.Usuario;
*/

/** import do Teste produto
    import br.com.SistemaEstoque.dao.ProdutoDAO;
    import br.com.SistemaEstoque.model.Produto;
*/

/** import do teste Categoria
    import br.com.SistemaEstoque.dao.CategoriaDAO;
    import br.com.SistemaEstoque.model.Categoria;
*/


/**
 *
 * @author paulo
 */
public class Main {
    public static void main(String[] args) {
        
        /** Teste Produto (Aprovado)
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        produto.setNome("Paulo");
        produto.setDescricao("Sou lindo");
        produto.setPrecoCusto(25.90);
        produto.setPrecoVenda(5000.00);
        produto.setCodigoBarras("6546156120203");
        produto.setIdCategoria(1);
        produto.setIdFornecedor(1);
        
        produtoDAO.save(produto);
        */
        
        /** teste categoria (Aprovado)
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = new Categoria();
        
        categoria.setNome("Diversos");
        categoria.setDescricao("Teste descrição");
        
        categoriaDAO.save(categoria);
        */
        
        /** Teste Usuario (Aprovado)
        UsuarioDAO  userDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        usuario.setNome("Paulo Henrique");
        usuario.setEmail("paulo.teste@gmail.com");
        usuario.setSenhaHash("NuncaVaodescobrir123");
        usuario.setPerfil("Admin");
        usuario.setStatusUsuario(true);
        
        userDAO.save(usuario);
        */
        
        /** Testes Fornecedor (Aprovado)
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setNome("Apple");
        fornecedor.setCnpj("123456789101234451");
        fornecedor.setTelefone("11985630348");
        fornecedor.setEmail("paulo.testes@gmail.com");
        
        fornecedorDAO.save(fornecedor);
        */
     }
}
