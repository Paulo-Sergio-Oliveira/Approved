/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import Conexao.Conexao;
import Conexao.UsuarioCRUD;
import com.raven.model.Usuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;

/**
 *
 * @author paulo
 */
public class HomeSup extends javax.swing.JFrame {

    /**
     * Creates new form HomeSup
     */
    public HomeSup() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        listTable();
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tableScrollButton1 = new table.TableScrollButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        combobox1 = new com.raven.swing.Combobox();
        txtNome = new com.raven.swing.TextField();
        combobox2 = new com.raven.swing.Combobox();
        txtCpf = new com.raven.swing.TextField();
        txtEmail = new com.raven.swing.TextField();
        txtSenha = new com.raven.swing.TextField();
        BtInserir = new com.raven.swing.Button();
        BtUpdate = new com.raven.swing.Button();
        BtDelete = new com.raven.swing.Button();
        BtErase = new com.raven.swing.Button();
        BtSearch = new com.raven.swing.Button();
        Find = new com.raven.swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableScrollButton1.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N

        TbUser.setFont(new java.awt.Font("Fira Sans", 1, 14)); // NOI18N
        TbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "Formação", "Curso/Área", "E-mail", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbUser.setRowHeight(40);
        TbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbUser);

        tableScrollButton1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(tableScrollButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 312, 1366, 420));

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel2.setText("CPF");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel3.setText("Formação");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel4.setText("Curso/Área");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel6.setText("Senha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        jLabel7.setText("ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, -1));

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 740, -1, -1));

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aluno", "Professor" }));
        combobox1.setLabeText("");
        combobox1.setLineColor(new java.awt.Color(39, 174, 96));
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });
        getContentPane().add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 244, 60));

        txtNome.setLabelText("");
        txtNome.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtNome.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 244, 60));

        combobox2.setLabeText("");
        combobox2.setLineColor(new java.awt.Color(39, 174, 96));
        combobox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox2ActionPerformed(evt);
            }
        });
        getContentPane().add(combobox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 244, 60));

        txtCpf.setLabelText("");
        txtCpf.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtCpf.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 244, 60));

        txtEmail.setLabelText("");
        txtEmail.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtEmail.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 244, 60));

        txtSenha.setLabelText("");
        txtSenha.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtSenha.setSelectionColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 244, 60));

        BtInserir.setBackground(new java.awt.Color(0, 70, 81));
        BtInserir.setForeground(new java.awt.Color(255, 255, 255));
        BtInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/insert.png"))); // NOI18N
        BtInserir.setText("Inserir");
        BtInserir.setFont(new java.awt.Font("Fira Sans", 1, 12)); // NOI18N
        BtInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtInserirActionPerformed(evt);
            }
        });
        getContentPane().add(BtInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 90, 50));

        BtUpdate.setBackground(new java.awt.Color(0, 70, 81));
        BtUpdate.setForeground(new java.awt.Color(255, 255, 255));
        BtUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit.png"))); // NOI18N
        BtUpdate.setText("Alterar");
        BtUpdate.setFont(new java.awt.Font("Fira Sans", 1, 12)); // NOI18N
        BtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(BtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 90, 50));

        BtDelete.setBackground(new java.awt.Color(0, 70, 81));
        BtDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete.png"))); // NOI18N
        BtDelete.setText("Excluir");
        BtDelete.setFont(new java.awt.Font("Fira Sans", 1, 12)); // NOI18N
        BtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(BtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 160, 90, 50));

        BtErase.setBackground(new java.awt.Color(0, 70, 81));
        BtErase.setForeground(new java.awt.Color(255, 255, 255));
        BtErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/clear.png"))); // NOI18N
        BtErase.setText("Limpar");
        BtErase.setFont(new java.awt.Font("Fira Sans", 1, 12)); // NOI18N
        BtErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEraseActionPerformed(evt);
            }
        });
        getContentPane().add(BtErase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 240, 300, 50));

        BtSearch.setBackground(new java.awt.Color(0, 70, 81));
        BtSearch.setForeground(new java.awt.Color(255, 255, 255));
        BtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N
        BtSearch.setText("Pesquisar");
        BtSearch.setFont(new java.awt.Font("Fira Sans", 1, 12)); // NOI18N
        BtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(BtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 90, 30));

        Find.setLabelText("");
        Find.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        Find.setSelectionColor(new java.awt.Color(0, 0, 0));
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });
        getContentPane().add(Find, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 245, 280, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbUserMouseClicked
        LoadData();
    }//GEN-LAST:event_TbUserMouseClicked

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        String display = combobox1.getSelectedItem().toString();
        switch (display) {
            case "Aluno":
            Vestibulando();
            break;
            case "Professor":
            Professor();
            break;
        }
    }//GEN-LAST:event_combobox1ActionPerformed

    private void combobox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox2ActionPerformed

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        StringBuilder cpf = new StringBuilder(txtCpf.getText());
        if ((cpf).length() > 2 && (cpf).length() < 4) {
            txtCpf.setText(cpf+".");
        }else if((cpf).length() > 6 && (cpf).length() < 8){
            txtCpf.setText(cpf+".");
        }else if((cpf).length() > 10 && (cpf).length() < 12){
            txtCpf.setText(cpf+"-");
        }else if((cpf).length() == 14){
            cpf.deleteCharAt(13);
            txtCpf.setText(cpf+"");
        }else if((cpf).length() == 12){
            cpf.deleteCharAt(11);
            txtCpf.setText(cpf+"");
        }else if((cpf).length() == 8){
            cpf.deleteCharAt(7);
            txtCpf.setText(cpf+"");
        }else if((cpf).length() == 4){
            cpf.deleteCharAt(3);
            txtCpf.setText(cpf+"");
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyTyped

    private void BtInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtInserirActionPerformed
        try {
            Insert();
        } catch (SQLException ex) {
            Logger.getLogger(HomeSup.class.getName()).log(Level.SEVERE, null, ex);
        }
        listTable();
    }//GEN-LAST:event_BtInserirActionPerformed

    private void BtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtUpdateActionPerformed
        try {
            Update();
        } catch (SQLException ex) {
            Logger.getLogger(HomeSup.class.getName()).log(Level.SEVERE, null, ex);
        }
        listTable();
    }//GEN-LAST:event_BtUpdateActionPerformed

    private void BtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDeleteActionPerformed
        try {
            Delete();
        } catch (SQLException ex) {
            Logger.getLogger(HomeSup.class.getName()).log(Level.SEVERE, null, ex);
        }
        listTable();
        Erase();
    }//GEN-LAST:event_BtDeleteActionPerformed

    private void BtEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEraseActionPerformed
        Erase();
    }//GEN-LAST:event_BtEraseActionPerformed

    private void BtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSearchActionPerformed
        findTable();
    }//GEN-LAST:event_BtSearchActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FindActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeSup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeSup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button BtDelete;
    private com.raven.swing.Button BtErase;
    private com.raven.swing.Button BtInserir;
    private com.raven.swing.Button BtSearch;
    private com.raven.swing.Button BtUpdate;
    private com.raven.swing.TextField Find;
    private javax.swing.JTable TbUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.Combobox combobox1;
    private com.raven.swing.Combobox combobox2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private table.TableScrollButton tableScrollButton1;
    private com.raven.swing.TextField txtCpf;
    private com.raven.swing.TextField txtEmail;
    private javax.swing.JTextField txtId;
    private com.raven.swing.TextField txtNome;
    private com.raven.swing.TextField txtSenha;
    // End of variables declaration//GEN-END:variables
    private void Vestibulando(){
        combobox2.removeAllItems();
        combobox2.addItem("Agropecuária");
combobox2.addItem("Alimentos");
combobox2.addItem("Análise de Dados");
combobox2.addItem("Análise e Desenvolvimento de Sistemas");
combobox2.addItem("Apicultura e Meliponicultura");
combobox2.addItem("Aquicultura");
combobox2.addItem("Arqueologia");
combobox2.addItem("Arquitetura de Dados");
combobox2.addItem("Artes do Espetáculo");
combobox2.addItem("Artes e Mídias Digitais");
combobox2.addItem("Assessoria Executiva Digital");
combobox2.addItem("Atividades de Inteligência e Gestão de Sigilos");
combobox2.addItem("Auditoria em Saúde");
combobox2.addItem("Automação de Escritórios e Secretariado");
combobox2.addItem("Automação e Manufatura Digital");
combobox2.addItem("Automação Industrial");
combobox2.addItem("Banco de Dados");
combobox2.addItem("Big Data e Inteligência Analítica");
combobox2.addItem("Big Data no Agronegócio");
combobox2.addItem("Biocombustíveis");
combobox2.addItem("Bioenergia");
combobox2.addItem("Bioinformática");
combobox2.addItem("Biotecnologia");
combobox2.addItem("Blockchain e Criptografia Digital");
combobox2.addItem("Cafeicultura");
combobox2.addItem("Cibersegurança");
combobox2.addItem("Ciência de Dados");
combobox2.addItem("Cinema e Audiovisual");
combobox2.addItem("Coach Digital");
combobox2.addItem("Coaching e Mentoring");
combobox2.addItem("Coding");
combobox2.addItem("Comércio Exterior");
combobox2.addItem("Computação em Nuvem");
combobox2.addItem("Comunicação Assistiva");
combobox2.addItem("Comunicação Digital");
combobox2.addItem("Comunicação em Computação Gráfica");
combobox2.addItem("Comunicação em Mídias Digitais");
combobox2.addItem("Comunicação Institucional");
combobox2.addItem("Conservação e Restauro");
combobox2.addItem("Construção Civil");
combobox2.addItem("Construção de Edifícios");
combobox2.addItem("Construção Naval");
combobox2.addItem("Controle Ambiental ");
combobox2.addItem("Controle de Obras");
combobox2.addItem("Cosmetologia e Estética");
combobox2.addItem("Cozinha Contemporânea");
combobox2.addItem("Data Science");
combobox2.addItem("Defesa Cibernética");
combobox2.addItem("Defesa Médica Hospitalar");
combobox2.addItem("Desenho de Animação");
combobox2.addItem("Desenvolvimento Back-End");
combobox2.addItem("Desenvolvimento de Aplicativos para Dispositivos Móveis");
combobox2.addItem("Desenvolvimento de Produtos Plásticos");
combobox2.addItem("Desenvolvimento de Sistemas");
combobox2.addItem("Desenvolvimento e Gestão de Startups");
combobox2.addItem("Desenvolvimento Mobile");
combobox2.addItem("Desenvolvimento para Internet");
combobox2.addItem("Desenvolvimento para Web");
combobox2.addItem("Design");
combobox2.addItem("Design Comercial");
combobox2.addItem("Design de Animação");
combobox2.addItem("Design de Aplicações e Interfaces Digitais");
combobox2.addItem("Design de Experiência e de Serviços");
combobox2.addItem("Design de Games");
combobox2.addItem("Design de Interiores");
combobox2.addItem("Design de Moda");
combobox2.addItem("Design de Produto");
combobox2.addItem("Design Editorial");
combobox2.addItem("Design Educacional");
combobox2.addItem("Design Gráfico");
combobox2.addItem("Devops");
combobox2.addItem("Digital Influencer");
combobox2.addItem("Digital Security");
combobox2.addItem("E-Commerce");
combobox2.addItem("Educação e Processos de Trabalho: Alimentação Escolar");
combobox2.addItem("Educador Social");
combobox2.addItem("Eletrônica Automotiva");
combobox2.addItem("Eletrônica Industrial");
combobox2.addItem("Eletrotécnica Industrial");
combobox2.addItem("Embelezamento e Imagem Pessoal");
combobox2.addItem("Empreendedorismo");
combobox2.addItem("Energias Renováveis");
combobox2.addItem("Escrita Criativa");
combobox2.addItem("Estética e Cosmética");
combobox2.addItem("Estilismo");
combobox2.addItem("Estradas");
combobox2.addItem("Eventos");
combobox2.addItem("Fabricação Mecânica");
combobox2.addItem("Filmmaker");
combobox2.addItem("Finanças, Blockchain e Criptomoedas");
combobox2.addItem("Fitoterapia");
combobox2.addItem("Fotografia");
combobox2.addItem("Fruticultura");
combobox2.addItem("Futebol");
combobox2.addItem("Game Design");
combobox2.addItem("Gastronomia");
combobox2.addItem("Geoprocessamento");
combobox2.addItem("Gerenciamento de Redes de Computadores");
combobox2.addItem("Gerontologia");
combobox2.addItem("Gestão Ambiental");
combobox2.addItem("Gestão Comercial");
combobox2.addItem("Gestão Cultural");
combobox2.addItem("Gestão da Avaliação");
combobox2.addItem("Gestão da Inovação e Empreendedorismo Digital");
combobox2.addItem("Gestão da Produção Industrial");
combobox2.addItem("Gestão da Qualidade");
combobox2.addItem("Gestão da Segurança Pública e Patrimonial");
combobox2.addItem("Gestão das Organizações do Terceiro Setor");
combobox2.addItem("Gestão das Relações Eletrônicas");
combobox2.addItem("Gestão da Tecnologia da Informação");
combobox2.addItem("Gestão de Agronegócios");
combobox2.addItem("Gestão de Cidades Inteligentes");
combobox2.addItem("Gestão de Cloud Computing");
combobox2.addItem("Gestão de Cooperativas");
combobox2.addItem("Gestão de Energia e Eficiência Energética");
combobox2.addItem("Gestão de Equinocultura");
combobox2.addItem("Gestão de Inventário Extrajudicial");
combobox2.addItem("Gestão de Investimentos");
combobox2.addItem("Gestão de Lojas e Pontos de Vendas");
combobox2.addItem("Gestão de Mercado de Capitais");
combobox2.addItem("Gestão de Micro e Pequenas Empresas");
combobox2.addItem("Gestão de Negócios");
combobox2.addItem("Gestão de Pessoas");
combobox2.addItem("Gestão de Produção Industrial");
combobox2.addItem("Gestão de Qualidade na Saúde");
combobox2.addItem("Gestão de Recursos Hídricos");
combobox2.addItem("Gestão de Recursos Humanos");
combobox2.addItem("Gestão de Representação Comercial");
combobox2.addItem("Gestão de Resíduos de Serviços de Saúde");
combobox2.addItem("Gestão de Saúde Pública");
combobox2.addItem("Gestão de Segurança Privada");
combobox2.addItem("Gestão de Seguros");
combobox2.addItem("Gestão de Serviços Judiciários e Notariais");
combobox2.addItem("Gestão Desportiva e de Lazer");
combobox2.addItem("Gestão de Telecomunicações");
combobox2.addItem("Gestão de Trânsito");
combobox2.addItem("Gestão de Turismo");
combobox2.addItem("Gestão Empresarial");
combobox2.addItem("Gestão em Serviços");
combobox2.addItem("Gestão Financeira");
combobox2.addItem("Gestão Hospitalar");
combobox2.addItem("Gestão Portuária");
combobox2.addItem("Gestão Pública");
combobox2.addItem("Gestão Tributária");
combobox2.addItem("Horticultura");
combobox2.addItem("Hotelaria");
combobox2.addItem("Informática");
combobox2.addItem("Informática para Negócios");
combobox2.addItem("Instalações Elétricas");
combobox2.addItem("Instrumentação Cirúrgica");
combobox2.addItem("Inteligência Artificial");
combobox2.addItem("Interiores e Decorações");
combobox2.addItem("Internet das Coisas");
combobox2.addItem("Investigação e Perícia Criminal");
combobox2.addItem("Irrigação e Drenagem");
combobox2.addItem("Jogos Digitais");
combobox2.addItem("Laticínios");
combobox2.addItem("Logística");
combobox2.addItem("Luteria");
combobox2.addItem("Manufatura Avançada");
combobox2.addItem("Manutenção de Aeronaves");
combobox2.addItem("Manutenção Industrial");
combobox2.addItem("Marketing");
combobox2.addItem("Massoterapia");
combobox2.addItem("Mecânica Automobilística");
combobox2.addItem("Mecânica de Precisão");
combobox2.addItem("Mecânica");
combobox2.addItem("Mecatrônica Automotiva");
combobox2.addItem("Mecatrônica Industrial");
combobox2.addItem("Mediação");
combobox2.addItem("Microeletrônica");
combobox2.addItem("Mídias Sociais");
combobox2.addItem("Mineração");
combobox2.addItem("Ministério Pastoral");
combobox2.addItem("Moda");
combobox2.addItem("Multidisciplinar em Dependência Química");
combobox2.addItem("Negócios Digitais");
combobox2.addItem("Negócios Imobiliários");
combobox2.addItem("Oftálmica");
combobox2.addItem("Óptica e Optometria");
combobox2.addItem("Paisagismo");
combobox2.addItem("Papel e Celulose");
combobox2.addItem("Paramedicina");
combobox2.addItem("Petróleo e Gás");
combobox2.addItem("Pilotagem Profissional de Aeronaves");
combobox2.addItem("Planejamento Logístico de Cargas");
combobox2.addItem("Podologia");
combobox2.addItem("Polímeros");
combobox2.addItem("Política e Gestão Cultural");
combobox2.addItem("Políticas e Estratégicas Públicas");
combobox2.addItem("Práticas Integrativas e Complementares");
combobox2.addItem("Processamento de Dados");
combobox2.addItem("Processos Ambientais");
combobox2.addItem("Processos Escolares");
combobox2.addItem("Processos Gerenciais");
combobox2.addItem("Processos Metalúrgicos");
combobox2.addItem("Processos Químicos");
combobox2.addItem("Produção Agrícola");
combobox2.addItem("Produção Agropecuária");
combobox2.addItem("Produção Audiovisual");
combobox2.addItem("Produção Cervejeira");
combobox2.addItem("Produção Cultural");
combobox2.addItem("Produção de Cacau e Chocolate");
combobox2.addItem("Produção de Cachaça");
combobox2.addItem("Produção de Fármacos");
combobox2.addItem("Produção de Grãos");
combobox2.addItem("Produção de Plástico");
combobox2.addItem("Produção Fonográfica");
combobox2.addItem("Produção Gráfica");
combobox2.addItem("Produção Industrial");
combobox2.addItem("Produção Leiteira");
combobox2.addItem("Produção Multimídia");
combobox2.addItem("Produção Musical");
combobox2.addItem("Produção Pesqueira");
combobox2.addItem("Produção Publicitária");
combobox2.addItem("Produção Sucroalcooleira");
combobox2.addItem("Produção Têxtil");
combobox2.addItem("Projeto de Estruturas Aeronáuticas");
combobox2.addItem("Projetos Mecânicos");
combobox2.addItem("Qualidade de Vida na Contemporaneidade");
combobox2.addItem("Quiropraxia");
combobox2.addItem("Radiologia");
combobox2.addItem("Redes de Computadores");
combobox2.addItem("Refrigeração e Climatização");
combobox2.addItem("Rochas Ornamentais");
combobox2.addItem("Saneamento Ambiental");
combobox2.addItem("Saúde Coletiva");
combobox2.addItem("Secretariado");
combobox2.addItem("Segurança Alimentar");
combobox2.addItem("Segurança no Trabalho");
combobox2.addItem("Service Design");
combobox2.addItem("Silvicultura");
combobox2.addItem("Sistema de Informação");
combobox2.addItem("Sistemas Automotivos");
combobox2.addItem("Sistemas Biomédicos");
combobox2.addItem("Sistemas para Internet");
combobox2.addItem("Soldagem");
combobox2.addItem("Streaming Profissional");
combobox2.addItem("Tecnologia da Informação");
combobox2.addItem("Tecnologia Eletrônica");
combobox2.addItem("Tecnologia em Controle Ambiental");
combobox2.addItem("Tecnologia Mecânica");
combobox2.addItem("Tecnologias Educacionais");
combobox2.addItem("Telemática");
combobox2.addItem("Terapias Integrativas e Complementares");
combobox2.addItem("Toxicologia Ambiental");
combobox2.addItem("Trânsito");
combobox2.addItem("Transporte Terrestre");
combobox2.addItem("Turismo");
combobox2.addItem("Tutoria de Educação a Distância");
combobox2.addItem("Varejo Digital");
combobox2.addItem("Visagismo e Terapias Capilares");
combobox2.addItem("Viticultura e Enologia");
    }
    private void Professor(){
        combobox2.removeAllItems();
combobox2.addItem("Artes");
combobox2.addItem("Educação Física");
combobox2.addItem("Filosofia");
combobox2.addItem("Sociologia");
combobox2.addItem("Inglês");
combobox2.addItem("Física");
combobox2.addItem("Química");
combobox2.addItem("Biologia");
combobox2.addItem("Geografia");
combobox2.addItem("História");
combobox2.addItem("Matemática");
combobox2.addItem("Língua Portuguesa");
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
    private void listTable(){
        try {
            Connection connection = new Conexao().getConnection();
            UsuarioCRUD usuariocrud = new UsuarioCRUD(connection);
            
            DefaultTableModel model = (DefaultTableModel) TbUser.getModel();
            model.setNumRows(0);
            
            ArrayList<Usuario> lista = usuariocrud.searchUser();
            for (int num = 1; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId(),
                    lista.get(num).getNome(),
                    lista.get(num).getCpf(),
                    lista.get(num).getFormacao(),
                    lista.get(num).getCursarea(),
                    lista.get(num).getEmail(),
                    lista.get(num).getSenha()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void findTable(){
        try {
            Usuario usuario = new Usuario();
            Connection connection = new Conexao().getConnection();
            UsuarioCRUD usuariocrud = new UsuarioCRUD(connection);
            
            DefaultTableModel model = (DefaultTableModel) TbUser.getModel();
            model.setNumRows(0);
            
            String nome = Find.getText();
            if ("".equals(nome)){
                listTable();
                JOptionPane.showMessageDialog(null, "Preencha o campo."); 
            } else {
                usuario.setNome(nome);
                ArrayList<Usuario> lista = usuariocrud.findUser(usuario);
            if(lista.size() == 0){
                listTable();
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            } else {
                for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId(),
                    lista.get(num).getNome(),
                    lista.get(num).getCpf(),
                    lista.get(num).getFormacao(),
                    lista.get(num).getCursarea(),
                    lista.get(num).getEmail(),
                    lista.get(num).getSenha()
                });
            }
            }
            }   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void LoadData(){
        int setar = TbUser.getSelectedRow();
        txtId.setText(TbUser.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(TbUser.getModel().getValueAt(setar, 1).toString());
        txtCpf.setText(TbUser.getModel().getValueAt(setar, 2).toString());
        combobox1.setSelectedItem(TbUser.getModel().getValueAt(setar, 3).toString());
        combobox2.setSelectedItem(TbUser.getModel().getValueAt(setar, 4).toString());
        txtEmail.setText(TbUser.getModel().getValueAt(setar, 5).toString());
        txtSenha.setText(TbUser.getModel().getValueAt(setar, 6).toString());
    }
    private void Erase(){
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        combobox2.removeAllItems();
        txtEmail.setText("");
        txtSenha.setText("");
    }
    private void Update() throws SQLException{
        String nome, cpf, formacao, cursarea, email, senha;
        int id;
        
        if("".equals(txtId.getText())){
            JOptionPane.showMessageDialog(null, "Selecione um Usuário.");
        }
        id = Integer.parseInt(txtId.getText());
        nome = txtNome.getText();
        cpf = txtCpf.getText();
        formacao = combobox1.getSelectedItem().toString();
        cursarea = combobox2.getSelectedItem().toString();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        
        Usuario usuario = new Usuario();
        
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setCpf(cpf);
        usuario.setFormacao(formacao);
        usuario.setCursarea(cursarea);
        usuario.setSenha(senha);
        
        if("".equals(email) || "".equals(senha) || "".equals(nome) || "".equals(cpf)){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        }else if(!isValidEmailAddressRegex(email)){
            JOptionPane.showMessageDialog(null, "Você não digitou um tipo email.");
        }else if(!isValidCPFRegex(cpf)){
            JOptionPane.showMessageDialog(null, "Você não digitou um tipo CPF.");
        }else if((senha).length() < 8){
            JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres.");
        } else {
            Connection connection = new Conexao().getConnection();
            UsuarioCRUD usuariocrud = new UsuarioCRUD(connection);
            usuariocrud.update(usuario);
        }
    }
    private void Insert() throws SQLException{
        String nome, cpf, formacao, cursarea, email, senha;

        Connection conexao = new Conexao().getConnection();
        UsuarioCRUD usuarioCrud = new UsuarioCRUD(conexao);
        Usuario usuario = new Usuario();
        
        if("".equals(txtNome.getText()) || "".equals(txtNome.getText()) || "".equals(txtEmail.getText()) || "".equals(txtSenha.getText())){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        } else if(combobox1.getSelectedItem() == null || combobox2.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção.");
        }else if(!isValidEmailAddressRegex(txtEmail.getText())){
            JOptionPane.showMessageDialog(null, "Você não digitou um tipo email.");
        }else if(!isValidCPFRegex(txtCpf.getText())){
            JOptionPane.showMessageDialog(null, "Você não digitou um tipo CPF.");
        }else if(usuarioCrud.autenticarExistenciaEmail(txtEmail.getText())){
            JOptionPane.showMessageDialog(null, "Este email já existe, tente outro.");
        }else if(usuarioCrud.autenticarExistenciaCPF(txtCpf.getText())){
            JOptionPane.showMessageDialog(null, "Este cpf já existe, tente outro.");
        }else if((txtSenha.getText()).length() < 8){
            JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres.");
        }else {
            nome = txtNome.getText();
            cpf = txtCpf.getText();
            formacao = combobox1.getSelectedItem().toString();
            cursarea = combobox2.getSelectedItem().toString();
            email = txtEmail.getText();
            senha = txtSenha.getText();
            
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setCpf(cpf);
            usuario.setFormacao(formacao);
            usuario.setCursarea(cursarea);
            usuario.setSenha(senha);
        
            Connection connection = new Conexao().getConnection();
            UsuarioCRUD usuariocrud = new UsuarioCRUD(connection);
            usuariocrud.insert(usuario);
        }
    }
    private void Delete() throws SQLException{
        int id;
        
        if("".equals(txtId.getText())){
            JOptionPane.showMessageDialog(null, "Selecione um Usuário.");
        }
        id = Integer.parseInt(txtId.getText());

        
        Usuario usuario = new Usuario();
        
        usuario.setId(id);
        
        Connection connection = new Conexao().getConnection();
        UsuarioCRUD usuariocrud = new UsuarioCRUD(connection);
        usuariocrud.delete(usuario);
    }
}