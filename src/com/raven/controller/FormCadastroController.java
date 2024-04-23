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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.raven.model.Usuario;

public class FormCadastroController {
    public void cadRealizado(){
        view.getjLMessage2().setText("Cadastro Realizado Com Sucesso!");
    }
    private Main view;

    public FormCadastroController(Main view) {
        this.view = view;
    }
    
    public static boolean isValidEmailAddressRegex(String email) {
    boolean isEmailIdValid = false;
    if (email != null && email.length() > 0) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isEmailIdValid = true;
        }
    }
    return isEmailIdValid;
    }
    public static boolean isValidCPFRegex(String email) {
    boolean isCPFIdValid = false;
    if (email != null && email.length() > 0) {
        String expression = "^([0-9]{3}+\\.)?([0-9]{3}+\\.)?([0-9]{3}+-)?([0-9]{2})$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isCPFIdValid = true;
        }
    }
    return isCPFIdValid;
    }
    public boolean salvaUsuario() throws SQLException, InterruptedException{
        boolean ok = false;
        String nome = view.getjTnome().getText();
        String cpf = view.getjTcpf().getText();
        String email = view.getjTemail().getText();
        String formacao = (String) view.getjTcombobox1().getSelectedItem();
        String cursarea = (String) view.getjTcombobox2().getSelectedItem();
        String senha = String.valueOf(view.getjTsenha().getPassword());
        Connection conexao = new Conexao().getConnection();
        UsuarioCRUD usuarioCrud = new UsuarioCRUD(conexao);
        if("".equals(email) || "".equals(senha) || "".equals(nome) || "".equals(cpf)){
        view.getjLMessage().setText("Preencha todos os campos.");
        }else if(formacao == null || cursarea == null) {
            view.getjLMessage().setText("Selecione uma opção.");
        }else if(!isValidEmailAddressRegex(email)){
            view.getjLMessage().setText("Você não digitou um tipo email.");
        }else if(!isValidCPFRegex(cpf)){
            view.getjLMessage().setText("Você não digitou um tipo CPF.");
        }else if(usuarioCrud.autenticarExistenciaEmail(email)){
            view.getjLMessage().setText("Este email já existe, tente outro.");
        }else if(usuarioCrud.autenticarExistenciaCPF(cpf)){
            view.getjLMessage().setText("Este cpf já existe, tente outro.");
        }else if((senha).length() < 8){
            view.getjLMessage().setText("Sua senha deve conter no mínimo 8 caracteres.");
        }else{
            Usuario usuario = new Usuario(nome, email, senha, cpf, formacao, cursarea);
            try {
                usuarioCrud.insert(usuario);
                ok = true;
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ok;
    }
}
