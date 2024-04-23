package Conexao;

import java.sql.*;
import com.raven.model.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioCRUD {
    private final Connection connection;
    ArrayList<Usuario> lista = new ArrayList<>();

    public UsuarioCRUD(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO `usuario` (`id`, `nome`, `cpf`, `formacao`, "
                + "`curso/area`, `email`, `senha`) VALUES (NULL, '"
                +usuario.getNome()+"', '"+usuario.getCpf()+"', '"
                +usuario.getFormacao()+"', '"+usuario.getCursarea()+"', '"
                +usuario.getEmail()+"', '"+usuario.getSenha()+"');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

    public boolean autenticarUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM `usuario` WHERE `email` LIKE '"+usuario.getEmail()+"' AND `senha` LIKE '"+usuario.getSenha()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        if (statement.execute()){
            System.out.println("Login Realizado");
        } else {
            System.out.println("Falha no Login");
        }
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
    
    public boolean autenticarExistenciaEmail(String email) throws SQLException {
        String sql = "SELECT * FROM `usuario` WHERE `email` LIKE '"+email+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet(); 
        return resultSet.next();
    }
    public boolean autenticarExistenciaCPF(String cpf) throws SQLException {
        String sql = "SELECT * FROM `usuario` WHERE `cpf` LIKE '"+cpf+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet(); 
        return resultSet.next();
    }
    
    public ArrayList<Usuario> searchUser() throws SQLException {
        String sql = "SELECT * FROM `usuario`";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setFormacao(resultSet.getString("formacao"));
            usuario.setCursarea(resultSet.getString("curso/area"));
            usuario.setSenha(resultSet.getString("senha"));
            lista.add(usuario);
        }
        return lista;
    }
    
    public ArrayList<Usuario> findUser(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM `usuario` WHERE `nome` LIKE '%"+usuario.getNome()+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setFormacao(resultSet.getString("formacao"));
            usuario.setCursarea(resultSet.getString("curso/area"));
            usuario.setSenha(resultSet.getString("senha"));
            lista.add(usuario);
        }
        return lista;
    }
    
    public ArrayList<Usuario> showUser(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM `usuario` WHERE `email` LIKE '%"+usuario.getEmail()+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setFormacao(resultSet.getString("formacao"));
            usuario.setCursarea(resultSet.getString("curso/area"));
            usuario.setSenha(resultSet.getString("senha"));
            lista.add(usuario);
        }
        return lista;
    }
    public void update(Usuario usuario) throws SQLException{
        String sql = "UPDATE `usuario` SET `nome` = '"+usuario.getNome()+"', "
                + "`cpf` = '"+usuario.getCpf()+"', `formacao` = '"
                +usuario.getFormacao()+"', "+ "`curso/area` = '"
                +usuario.getCursarea()+"', `email` = '"+usuario.getEmail()+
                "', `senha` = '"+usuario.getSenha()+"' WHERE `id` = '"
                +usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    public void delete(Usuario usuario) throws SQLException{
        String sql = "DELETE FROM `usuario` WHERE `id` = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
}
