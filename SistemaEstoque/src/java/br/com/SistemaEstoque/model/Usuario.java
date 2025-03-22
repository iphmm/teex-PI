package br.com.SistemaEstoque.model;

import java.sql.Timestamp;

/**
 *
 * @author paulo
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senhaHash;
    private String perfil;
    private boolean statusUsuario;
    private Timestamp dataCadastro;
    
    //Construitor
    public Usuario(int idUsuario, String nome, String email, String senhaHash,
                    String perfil, Boolean statusUsuario, Timestamp datacadastro){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.perfil = perfil;
        this.statusUsuario = statusUsuario;
        this.dataCadastro = new Timestamp(System.currentTimeMillis());
    }
    
    //getters e setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(boolean statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
}
