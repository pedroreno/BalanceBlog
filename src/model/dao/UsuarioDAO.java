package model.dao;

import model.Usuario;
import model.dao.interfacesDAO.InterUsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.List;

public class UsuarioDAO implements InterUsuarioDAO {

    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public UsuarioDAO(){
        pegarConexao();

    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  Usuario DAO ...");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... UsuarioDAO: ", e);
        }
    }





    @Override
    public Usuario insert(Usuario usuario) {
        try{
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO usuario(id, nome, senha, email, papeis)" +
                    " VALUES (?, ?, ?, ?, ?)");

            sql.setLong(1, usuario.getId());
            sql.setString(2, usuario.getNome());
            sql.setString(3, usuario.getSenha());
            sql.setString(4, usuario.getEmail());
            sql.setArray(5, (Array) usuario.getPapeis());

            ResultSet rs = sql.executeQuery();
            System.out.println("Conectando ... insert Usuario");
            rs.next();

            sql.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão... insert Usuario");
        }

        return null;
    }

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = null;

        try{
            PreparedStatement sql = conexao.prepareStatement("select * from balanceblog.usuario where id_usuario = ?");
            sql.setString(1, id.toString());
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado ... findById UsuarioDAO");
            rs.next();

            usuario = new Usuario();
            usuario.setId(rs.getLong(1));
            usuario.setNome(rs.getString(2));
            usuario.setSenha(rs.getString(3));
            usuario.setEmail(rs.getString(4));

            sql.close();
            rs.close();

            return usuario;

        } catch (Exception e) {
            System.out.println("\nErro de conexão... findByID UsuarioDAO");
        }
        return usuario;
    }

    @Override
    public Usuario findByName(String name) {
        Usuario usuario = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("select * from balanceblog.usuario where nome_usuario = ?");
            sql.setString(1, name);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findByName UsuarioDAO");
            rs.next();

            usuario = new Usuario();
            usuario.setId(rs.getLong("id_usuario"));
            usuario.setNome(rs.getString("nome_usuario"));
            usuario.setSenha(rs.getString("senha_usuario"));
            usuario.setEmail(rs.getString("email_usuario"));

            sql.close();
            rs.close();

            return usuario;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nErro de conexão ... findByName UsuarioDAO");
        }

        return usuario;


    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario update(Usuario usuAnt, Usuario usuAt) {
        return null;
    }

    @Override
    public boolean delete(Usuario usuario) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
