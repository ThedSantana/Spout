/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spout.model;

/**
 *
 * @author Windows
 */
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String generofavorito1;
    private String generofavorito2;
    private String generofavorito3;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }     

    public String getGenerofavorito1() {
        return generofavorito1;
    }

    public void setGenerofavorito1(String generofavorito1) {
        this.generofavorito1 = generofavorito1;
    }

    public String getGenerofavorito2() {
        return generofavorito2;
    }

    public void setGenerofavorito2(String generofavorito2) {
        this.generofavorito2 = generofavorito2;
    }

    public String getGenerofavorito3() {
        return generofavorito3;
    }

    public void setGenerofavorito3(String generofavorito3) {
        this.generofavorito3 = generofavorito3;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", generofavorito1=" + generofavorito1 + ", generofavorito2=" + generofavorito2 + ", generofavorito3=" + generofavorito3 + '}';
    }    
    
}
