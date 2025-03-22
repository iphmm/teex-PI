package br.com.SistemaEstoque.model;

import java.sql.Timestamp;

/**
 *
 * @author phmm
 */
public class Produto {
    // Atributos da classe Produto
    private int idProduto;
    private String nome;
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private String codigoBarras;
    private int idCategoria;
    private int idFornecedor;
    private Timestamp dataCadastro;
    
    
    // Construtor da classe Produto
    public Produto(int idProduto, String nome, String descricao, double precoCusto, double precoVenda, String codigoBarras, int idCategoria, int idFornecedor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.codigoBarras = codigoBarras;
        this.idCategoria = idCategoria;
        this.idFornecedor = idFornecedor;
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }

    public Produto() {
        
    }

    //getters e setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
}