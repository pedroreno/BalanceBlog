package model.dao;

import model.Usuario;
import model.dao.interfacesDAO.InterUsuarioDAO;

import java.sql.*;
import java.util.ArrayList;
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

            System.out.println("Conectado com sucesso...  UsuarioDAO");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... UsuarioDAO: ", e);
        }
    }

    @Override
    public Usuario insert(Usuario usuario) {
        try{
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO usuario (nome_usuario, senha_usuario, email_usuario, papel_usuario)" +
                    " VALUES (?, ?, ?, ?)");

            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getSenha());
            sql.setString(3, usuario.getEmail());
            sql.setString(4, usuario.getPapel());

            sql.executeUpdate();
            System.out.println("Conectando ... insert Usuario");

            sql.close();
        } catch (SQLException e) {
            System.out.println("Erro de conexão... insert Usuario");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario findById(int id) {
        Usuario usuario = null;

        try{
            PreparedStatement sql = conexao.prepareStatement("select * from balanceblog.usuario where id_usuario = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado ... findById UsuarioDAO");
            rs.next();

            if(!rs.first()) return null;
            else {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setPapel(rs.getString("papel_usuario"));

                sql.close();
                rs.close();

                return usuario;
            }
        } catch (Exception e) {
            System.out.println("\nErro de conexão... findByID UsuarioDAO");
        }
        return null;
    }

    @Override
    public Usuario findByName(String nome) {
        Usuario usuario = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("select * from balanceblog.usuario where nome_usuario = ?");
            sql.setString(1, nome);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findByName UsuarioDAO");
            rs.next();

            if(!rs.first()) return null;
            else {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setPapel(rs.getString("papel_usuario"));

                sql.close();
                rs.close();

                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nErro de conexão ... findByName UsuarioDAO");
        }

        return null;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList();
        Usuario usuario;
        ResultSet rs;
        try{
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM usuario");
            rs = sql.executeQuery();
            System.out.println("Conectado... findAll UsuarioDAO");

            while(rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setPapel(rs.getString("papel_usuario"));

                usuarios.add(usuario);
            }
            rs.close();
            sql.close();
            return usuarios;

        } catch(SQLException e) {
            System.out.println("Erro de conexão... findAll UsuarioDAO");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario update(Usuario usuAnt, Usuario usuAt) {
        return null;
    }

    @Override
    public void deleteById(int idUsuario) {
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            sql.setInt(1, idUsuario);

            sql.executeUpdate();
            System.out.println("Conectado... deleteById UsuarioDAO");

            sql.close();

        } catch(SQLException e) {
            System.out.println("Erro de conexão... deleteById UsuarioDAO");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByName(String nomeUsuario) {
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM usuario WHERE nome_usuario = ?");
            sql.setString(1, nomeUsuario);

            sql.executeUpdate();
            System.out.println("Conectado... deleteByName UsuarioDAO");

            sql.close();

        } catch(SQLException e) {
            System.out.println("Erro de conexão... deleteByName UsuarioDAO");
            e.printStackTrace();
        }
    }
}
