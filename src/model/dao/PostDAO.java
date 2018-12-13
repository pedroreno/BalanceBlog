package model.dao;

import model.Post;
import model.dao.interfacesDAO.InterPostDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements InterPostDAO {

    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public PostDAO(){
        pegarConexao();
    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  PostDAO");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... PostDAO: ", e);
        }
    }

    @Override
    public void insert(Post post) {
        try {
            System.out.println("Estou em PostDAO insert");
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO post (imagem_post, titulo_post, texto_post, id_usuario)" +
                    "VALUES (?, ?, ?, ?)");

            sql.setString(1, post.getImagem());
            sql.setString(2, post.getTitulo());
            sql.setString(3, post.getTexto());
            sql.setInt(4, post.getIdUsuario());

            sql.executeUpdate();
            System.out.println("Conectado... insert Post");

            sql.close();
        } catch(SQLException e) {
            System.out.println("Erro de conexão... insert Post");
            e.printStackTrace();
        }
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM post WHERE id_post = ?");
            sql.setInt(1, id);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findById Post");
            rs.next();

            if(!rs.first()) return null;
            else {

                post = new Post();
                post.setId(rs.getInt("id_post"));
                post.setImagem(rs.getString("imagem_post"));
                post.setTitulo(rs.getString("titulo_post"));
                post.setTexto(rs.getString("texto_post"));
                post.setIdUsuario(rs.getInt("id_usuario"));

                sql.close();
                rs.close();

                return post;
            }
        } catch(SQLException e) {
            System.out.println("Erro de conexão... findById Post");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post findByTitulo(String titulo) {
        Post post = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM post WHERE titulo_post = ?");
            sql.setString(1, titulo);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findByName Post");
            rs.next();

            if(!rs.first()) return null;
            else {
                post = new Post();
                post.setId(rs.getInt("id_post"));
                post.setImagem(rs.getString("imagem_post"));
                post.setTitulo(rs.getString("titulo_post"));
                post.setTexto(rs.getString("texto_post"));
                post.setIdUsuario(rs.getInt("id_usuario"));

                sql.close();
                rs.close();

                return post;
            }
        } catch(SQLException e) {
            System.out.println("Erro de conexão... findByName Post");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Post> findByCategoria(String categoria) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList();
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM post");
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findAll PostDAO");

            while(rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id_post"));
                post.setImagem(rs.getString("imagem_post"));
                post.setTitulo(rs.getString("titulo_post"));
                post.setTexto(rs.getString("texto_post"));
                post.setIdUsuario(rs.getInt("id_usuario"));

                posts.add(post);
            }

            rs.close();
            sql.close();
            return posts;

        } catch(SQLException e) {
            System.out.println("Erro de conexão... findAll PostDAO");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Post update(Post postAnterior, Post postAtual) {
        return null;
    }

    @Override
    public void deleteById(int idPost) {
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM post WHERE id_post = ?");
            sql.setInt(1,idPost);

            sql.executeUpdate();
            System.out.println("Conectado... deleteById PostDAO");
            sql.close();

        } catch(SQLException e) {
            System.out.println("Erro de conexão... deleteById PostDAO");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByTitulo(String tituloPost) {
        try {
            PreparedStatement sql = conexao.prepareStatement("DELETE FROM post WHERE titulo_post = ?");
            sql.setString(1, tituloPost);

            sql.executeUpdate();
            System.out.println("Conectado... deleteByTitulo PostDAO");
            sql.close();

        } catch(SQLException e) {
            System.out.println("Erro de conexão... deleteByName PostDAO");
            e.printStackTrace();
        }
    }

}
