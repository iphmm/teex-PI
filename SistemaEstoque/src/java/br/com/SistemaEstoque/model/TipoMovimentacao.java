package br.com.SistemaEstoque.model;

/**
 *
 * @author paulo
 */
public class TipoMovimentacao {
    private int idTipo;
    private String descricao;
    
    public TipoMovimentacao(int idTipo, String descricao){
        this.idTipo = idTipo;
        this.descricao = descricao;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    
}
