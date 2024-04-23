/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author Tobias
 */
public class Usuario {
    
    private String nome, cpf, formacao, cursarea, email, senha;
    private int id;
    
    public Usuario() {
    }
    
    public Usuario(String nome, String email, String senha, String cpf, String formacao, String cursarea) {
        this.nome = nome;
        this.cpf = cpf;
        this.formacao = formacao;
        this.cursarea = cursarea;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
   
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    public String getCursarea() {
        return cursarea;
    }

    public void setCursarea(String cursarea) {
        this.cursarea = cursarea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}