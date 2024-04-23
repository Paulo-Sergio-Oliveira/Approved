package com.raven.main;

import Conexao.Conexao;
import Conexao.UsuarioCRUD;
import com.raven.swing.PasswordField;
import com.raven.swing.TextField;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import com.raven.controller.FormCadastroController;
import com.raven.controller.LoginController;
import com.raven.model.Usuario;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import javax.swing.text.*;



public class Main extends javax.swing.JFrame {
    String display;
    private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;

    public Main() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(245, 245, 245));
        TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    background1.setAnimate(fraction);
                } else {
                    background1.setAnimate(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn) {
                    panelLogin.setVisible(false);
                    background1.setShowPaint(true);
                    panelBody.setAlpha(0);
                    panelBody.setVisible(true);
                    animatorBody.start();
                } else {
                    enableLogin(true);
                    txtUser.grabFocus();
                }
            }
        };
        TimingTarget targetBody = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (signIn) {
                    panelBody.setAlpha(fraction);
                } else {
                    panelBody.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (signIn == false) {
                    panelBody.setVisible(false);
                    background1.setShowPaint(false);
                    background1.setAnimate(1);
                    panelLogin.setVisible(true);
                    animatorLogin.start();
                }
            }
        };
        animatorLogin = new Animator(1500, targetLogin);
        animatorBody = new Animator(500, targetBody);
        animatorLogin.setResolution(0);
        animatorBody.setResolution(0);
    }

    Main(Home aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.Background();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmdSignIn = new com.raven.swing.Button();
        txtUser = new com.raven.swing.TextField();
        txtPass = new com.raven.swing.PasswordField();
        jLabel4 = new javax.swing.JLabel();
        cad = new javax.swing.JLabel();
        jLMessage2 = new javax.swing.JLabel();
        panelBody = new com.raven.swing.PanelTransparent();
        jPanel2 = new javax.swing.JPanel();
        jpCadastrar3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        jTnome = new com.raven.swing.TextField();
        jTemail = new com.raven.swing.TextField();
        jTcpf = new com.raven.swing.TextField();
        jTsenha = new com.raven.swing.PasswordField();
        combobox1 = new com.raven.swing.Combobox();
        combobox2 = new com.raven.swing.Combobox();
        jLabel3 = new javax.swing.JLabel();
        jLMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background1.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(0, 161, 129));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));

        cmdSignIn.setBackground(new java.awt.Color(0, 70, 81));
        cmdSignIn.setForeground(new java.awt.Color(255, 255, 255));
        cmdSignIn.setText("Entrar");
        cmdSignIn.setEffectColor(new java.awt.Color(199, 196, 255));
        cmdSignIn.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        cmdSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdSignInMouseClicked(evt);
            }
        });
        cmdSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSignInActionPerformed(evt);
            }
        });

        txtUser.setForeground(new java.awt.Color(51, 51, 51));
        txtUser.setCaretColor(new java.awt.Color(51, 51, 51));
        txtUser.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        txtUser.setLabelText("E-mail");
        txtUser.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtUser.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtPass.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPass.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        txtPass.setLabelText("Senha");
        txtPass.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        txtPass.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(68, 189, 50));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/com fundo braanco2.png"))); // NOI18N

        cad.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        cad.setForeground(new java.awt.Color(255, 255, 255));
        cad.setText("Cadastre-se");
        cad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(cmdSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cad)
                        .addGap(142, 142, 142))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cmdSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cad)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLMessage2.setFont(new java.awt.Font("Fira Sans ExtraBold", 0, 18)); // NOI18N
        jLMessage2.setForeground(new java.awt.Color(51, 255, 51));
        jLMessage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(543, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(482, 482, 482))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(jLMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(513, 513, 513))))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );

        background1.add(panelLogin, "card2");

        jPanel2.setBackground(new java.awt.Color(0, 161, 129));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));

        jpCadastrar3.setBackground(new java.awt.Color(0, 70, 81));
        jpCadastrar3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jpCadastrar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpCadastrar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpCadastrarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cadastrar");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpCadastrar3Layout = new javax.swing.GroupLayout(jpCadastrar3);
        jpCadastrar3.setLayout(jpCadastrar3Layout);
        jpCadastrar3Layout.setHorizontalGroup(
            jpCadastrar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrar3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jpCadastrar3Layout.setVerticalGroup(
            jpCadastrar3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrar3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        log.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        log.setForeground(new java.awt.Color(51, 51, 51));
        log.setText("Já possui login?");
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logMouseExited(evt);
            }
        });

        jTnome.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        jTnome.setLabelText("Nome");
        jTnome.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        jTnome.setSelectionColor(new java.awt.Color(0, 0, 0));

        jTemail.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        jTemail.setLabelText("E-mail");
        jTemail.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        jTemail.setSelectionColor(new java.awt.Color(0, 0, 0));

        jTcpf.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        jTcpf.setLabelText("CPF");
        jTcpf.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        jTcpf.setSelectionColor(new java.awt.Color(0, 0, 0));
        jTcpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTcpfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTcpfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTcpfKeyTyped(evt);
            }
        });

        jTsenha.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        jTsenha.setLabelText("Senha");
        jTsenha.setSelectedTextColor(new java.awt.Color(0, 161, 129));
        jTsenha.setSelectionColor(new java.awt.Color(0, 0, 0));

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aluno", "Professor" }));
        combobox1.setSelectedItem(null);
        combobox1.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        combobox1.setLabeText("Formação");
        combobox1.setLineColor(new java.awt.Color(39, 174, 96));
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });

        combobox2.setSelectedItem(null);
        combobox2.setFont(new java.awt.Font("Fira Sans", 0, 12)); // NOI18N
        combobox2.setLabeText("Curso/Área");
        combobox2.setLineColor(new java.awt.Color(39, 174, 96));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cadastre-se");

        jLMessage.setFont(new java.awt.Font("Fira Sans ExtraBold", 0, 18)); // NOI18N
        jLMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(log))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jpCadastrar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 269, Short.MAX_VALUE)
                .addComponent(jLMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(356, 356, 356)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(combobox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(108, 108, 108)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(combobox2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                .addComponent(jTcpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jpCadastrar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(129, 129, 129)))
        );

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBodyLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        background1.add(panelBody, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadMouseEntered
        cad.setForeground(Color.BLUE);
    }//GEN-LAST:event_cadMouseEntered
    
    private void cadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadMouseExited
        cad.setForeground(UIManager.getColor("[51,51,51]"));
    }//GEN-LAST:event_cadMouseExited

    private void cadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadMouseClicked
        if (!animatorLogin.isRunning()) {
            signIn = true;
            String user = txtUser.getText().trim();
            String pass = String.valueOf(txtPass.getPassword());
            boolean action = true;
            if (action) {
                animatorLogin.start();
                enableLogin(false);
            }
        }
    }//GEN-LAST:event_cadMouseClicked

    private void cmdSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSignInActionPerformed

    }//GEN-LAST:event_cmdSignInActionPerformed

    private void cmdSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSignInMouseClicked
        try {
            LoginController controlador = new com.raven.controller.LoginController(this);
            String email = getTxtUser().getText();
            String senha = String.valueOf(getTxtPass().getPassword());
            if(controlador.autenticar() && "sup.approved@gmail.com".equals(email) && "@Sup2023".equals(senha)){
                dispose();
                new HomeSup().setVisible(true);
            }else if(controlador.autenticar()){
                dispose();
                Usuario usuario = new Usuario();
                usuario.setEmail(txtUser.getText());
                Home home = new Home();
                home.exportEmail(usuario);
                home.setVisible(true);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_cmdSignInMouseClicked

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        display = combobox1.getSelectedItem().toString();
        switch (display) {
            case "Aluno":
            Vestibulando();
            break;
            case "Professor":
            Professor();
            break;
        }
    }//GEN-LAST:event_combobox1ActionPerformed

    private void jTcpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTcpfKeyTyped
        StringBuilder cpf = new StringBuilder(jTcpf.getText());
        if ((cpf).length() > 2 && (cpf).length() < 4) {
            jTcpf.setText(cpf+".");
        }else if((cpf).length() > 6 && (cpf).length() < 8){
            jTcpf.setText(cpf+".");
        }else if((cpf).length() > 10 && (cpf).length() < 12){
            jTcpf.setText(cpf+"-");
        }else if((cpf).length() == 14){
            cpf.deleteCharAt(13);
            jTcpf.setText(cpf+"");
        }else if((cpf).length() == 12){
            cpf.deleteCharAt(11);
            jTcpf.setText(cpf+"");
        }else if((cpf).length() == 8){
            cpf.deleteCharAt(7);
            jTcpf.setText(cpf+"");
        }else if((cpf).length() == 4){
            cpf.deleteCharAt(3);
            jTcpf.setText(cpf+"");
        }
    }//GEN-LAST:event_jTcpfKeyTyped

    private void jTcpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTcpfKeyReleased

    }//GEN-LAST:event_jTcpfKeyReleased

    private void jTcpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTcpfKeyPressed

    }//GEN-LAST:event_jTcpfKeyPressed

    private void logMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseExited
        log.setForeground(UIManager.getColor("[51,51,51]"));
    }//GEN-LAST:event_logMouseExited

    private void logMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseEntered
        log.setForeground(Color.BLUE);
    }//GEN-LAST:event_logMouseEntered

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked
        signIn = false;
        clearLogin();
        animatorBody.start();
    }//GEN-LAST:event_logMouseClicked

    private void jpCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCadastrarMouseClicked

        try {
            FormCadastroController controlador = new com.raven.controller.FormCadastroController(this);
            if(controlador.salvaUsuario()){
                signIn = false;
                clearLogin();
                animatorBody.start();
                controlador.cadRealizado();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jpCadastrarMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void enableLogin(boolean action) {
        txtUser.setEditable(action);
        txtPass.setEditable(action);
        cmdSignIn.setEnabled(action);
    }

    public void clearLogin() {
        txtUser.setText("");
        txtPass.setText("");
        txtUser.setHelperText("");
        txtPass.setHelperText("");
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Background background1;
    private javax.swing.JLabel cad;
    private com.raven.swing.Button cmdSignIn;
    private com.raven.swing.Combobox combobox1;
    private com.raven.swing.Combobox combobox2;
    private javax.swing.JLabel jLMessage;
    private javax.swing.JLabel jLMessage2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.raven.swing.TextField jTcpf;
    private com.raven.swing.TextField jTemail;
    private com.raven.swing.TextField jTnome;
    private com.raven.swing.PasswordField jTsenha;
    private javax.swing.JPanel jpCadastrar3;
    private javax.swing.JLabel log;
    private com.raven.swing.PanelTransparent panelBody;
    private javax.swing.JPanel panelLogin;
    private com.raven.swing.PasswordField txtPass;
    private com.raven.swing.TextField txtUser;
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
    
    public JLabel getjLMessage() {
        return jLMessage;
    }

    public void setjLMessage(JLabel jLMessage) {
        this.jLMessage = jLMessage;
    }
    
    public JLabel getjLMessage2() {
        return jLMessage2;
    }

    public void setjLMessage2(JLabel jLMessage2) {
        this.jLMessage2 = jLMessage2;
    }
    
    public JTextField getjTnome() {
        return jTnome;
    }

    public void setjTnome(JTextField jTnome) {
        this.jTnome = (TextField) jTnome;
    }
    
    public JTextField getjTcpf() {
        return jTcpf;
    }

    public void setjTcpf(JTextField jTcpf) {
        this.jTcpf = (TextField) jTcpf;
    }
    
    public JComboBox getjTcombobox1() {
        return combobox1;
    }

    public void setjTcombobox1(JComboBox jTcombobox1) {
        this.combobox1 = combobox1;
    }
    
    public JComboBox getjTcombobox2() {
        return combobox2;
    }

    public void setjTcombobox2(JComboBox jTcombobox2) {
        this.combobox2 = combobox2;
    }
    
    public JTextField getjTemail() {
        return jTemail;
    }

    public void setjTemail(JTextField jTemail) {
        this.jTemail = (TextField) jTemail;
    }

    public JPasswordField getjTsenha() {
        return jTsenha;
    }

    public void setjTsenha(JPasswordField jTsenha) {
        this.jTsenha = (PasswordField) jTsenha;
    }
    
    public JTextField getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(JTextField txtUser) {
        this.txtUser = (TextField) txtUser;
    }

    public JPasswordField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(JPasswordField txtPass) {
        this.txtPass = (PasswordField) txtPass;
    }

}
