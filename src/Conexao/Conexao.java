package Conexao;

import java.sql.*;

public class Conexao {
    public Connection getConnection() {  
        Connection Conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                Conexao = DriverManager.getConnection("jdbc:mysql://localhost/approved", "root", "");
                System.out.println("Conexao Realizada Com Sucesso");
        } catch (ClassNotFoundException ex) {
            System.out.println("BD não encontrado"+ ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco:"+ ex.getMessage());
        }
        return Conexao;
        
    }
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        conexao.getConnection();
    }
}