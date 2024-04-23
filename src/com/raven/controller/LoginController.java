/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.controller;

import Conexao.Conexao;
import Conexao.UsuarioCRUD;
import com.raven.main.Main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.raven.model.Usuario;
import java.awt.Color;


public class LoginController {
    private Main view;

    public LoginController(Main view) {
        this.view = view;
    }
    public boolean autenticar() throws SQLException{
        boolean ok = false;
        String email = view.getTxtUser().getText();
        String senha = String.valueOf(view.getTxtPass().getPassword());
        
        try {
            Usuario usuario = new Usuario(email, senha);
            Connection conexao = new Conexao().getConnection();
            UsuarioCRUD usuarioDao = new UsuarioCRUD(conexao);        
           
            if(usuarioDao.autenticarUsuario(usuario)){
                ok = true;
                System.out.println("Acesso Concedido");
            }else{
                 view.getjLMessage2().setForeground(Color.red);
                 view.getjLMessage2().setText("Email ou senha invalidos");
                 System.out.println("Acesso Negado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }   
}
