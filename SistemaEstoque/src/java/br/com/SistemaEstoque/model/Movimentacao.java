package br.com.SistemaEstoque.model;

import java.security.Timestamp;

/**
 *
 * @author paulo
 */
public class Movimentacao {
    private int idMovimentacao;
    private int idProduto;
    private int idTipo;
    private int idUsuario;
    private int quantidade;
    private double precoUnitario;
    private String observacao;
    private Timestamp dataMovimentacao;
    
    //Construtor
    public Movimentacao(int idMovimentacao, int idProduto, int idTipo,
                        int idUsuario, int quantidade, double precoUnitario,
                        String observacao, Timestamp dataMovimentacao){
        this.idMovimentacao = idMovimentacao;
        this.idProduto = idProduto;
        this.idTipo = idTipo;
        this.idUsuario = idUsuario;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.observacao = observacao;
        this.dataMovimentacao = dataMovimentacao;
    }
    
    //getters e setters

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Timestamp dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    
    
}
