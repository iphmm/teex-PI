package br.com.SistemaEstoque.aplicacao;

/** import do Teste produto
 * import br.com.SistemaEstoque.dao.ProdutoDAO;
    import br.com.SistemaEstoque.model.Produto;
* */
import br.com.SistemaEstoque.dao.CategoriaDAO;
import br.com.SistemaEstoque.model.Categoria;



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
        * */
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = new Categoria();
        
        categoria.setNome("Diversos");
        categoria.setDescricao("Teste descrição");
        
        categoriaDAO.save(categoria);
        
        
        
    }
}
