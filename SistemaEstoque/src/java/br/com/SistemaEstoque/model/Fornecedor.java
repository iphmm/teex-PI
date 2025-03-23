package br.com.SistemaEstoque.model;

import java.sql.Timestamp;

/**
 *
 * @author paulo
 */
public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private Timestamp dataCadastro;
    
    //Construtor da Classe Fornecedor
    public Fornecedor(){
        
    }
    
    public Fornecedor(int idForncedor, String nome, String cnpj, String telefone,
                      String email, Timestamp dataCadstro){
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }
    
    //getters e setters 

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

   
    
    
}
