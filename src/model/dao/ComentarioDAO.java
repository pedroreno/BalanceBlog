package model.dao;

import model.Comentario;
import model.dao.interfacesDAO.InterComentarioDAO;

import java.sql.*;

public class ComentarioDAO implements InterComentarioDAO {
    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public ComentarioDAO(){
        pegarConexao();
    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  ComentarioDAO");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... ComentarioDAO: ", e);
        }
    }

    @Override
    public void insert(Comentario comentario) {
        try {
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO comentario (id_post, id_usuario, texto_comentario)" +
                    "VALUES (?, ?, ?)");

            sql.setInt(1, comentario.getIdPost());
            sql.setInt(2, comentario.getIdUsuario());
            sql.setString(3, comentario.getTexto());

            sql.executeUpdate();
            System.out.println("Conectado... insert ComentarioDAO");

            sql.close();
        } catch(SQLException e) {
            System.out.println("Erro de conexão... insert ComentarioDAO");
            e.printStackTrace();
        }



    }

    @Override
    public Comentario findById(int id) {
        Comentario comentario = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM comentario WHERE id_comentario = ?");

            sql.setInt(1,id);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findById ComentarioDAO");
            rs.next();

            if(!rs.first()) return null;
            else {
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdPost(rs.getInt("id_post"));
                comentario.setIdUsuario(rs.getInt("id_usuario"));
                comentario.setTexto(rs.getString("texto_comentario"));

                sql.close();
                rs.close();

                return comentario;
            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão... findById ComentarioDAO");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Comentario[] deleteByUsuario(String usuario) {
        int idUsuario;
        try{
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM usuario WHERE nome_usuario = ?");
            sql.setString(1, usuario);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... deleteByUsuario ComentarioDAO");
            rs.next();

            if(!rs.first()) return null;
            else {
                idUsuario = rs.getInt("id_usuario");
                rs.close();
                sql.close();
            }

            sql = conexao.prepareStatement("DELETE FROM comentario WHERE id_usuario = ?");
            sql.setInt(1, idUsuario);
            sql.executeUpdate();
            System.out.println("Deletado com sucesso... deleteByUsuario ComentarioDAO");
            sql.close();


        } catch(SQLException e) {
            System.out.println("Erro de conexão... deleteByUsuario ComentarioDAO");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Comentario[] findByUsuarioID(int id) {
        return new Comentario[0];
    }

    @Override
    public Comentario[] findByPostID(int id) {
        return new Comentario[0];
    }

    @Override
    public Comentario[] findByUsuarioPost(int idUsuario, int idPost) {
        return new Comentario[0];
    }

}
