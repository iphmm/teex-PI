package br.com.SistemaEstoque.model;

/**
 *
 * @author paulo
 */
public class Categoria {
    // Atributos da Classe Categoria
    private int idCategoria;
    private String nome;
    private String descricao;
    
    
    //Construtor da Classe Categoria
    public Categoria(){
        
    }
    
    public Categoria(int idCategoria, String nome, String Descricao){
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    
    //getters e setters

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    
}
