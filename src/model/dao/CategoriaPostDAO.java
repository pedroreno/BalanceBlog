package model.dao;

import model.Categoria;
import model.CategoriaPost;
import model.dao.interfacesDAO.InterCategoriaPostDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaPostDAO implements InterCategoriaPostDAO {
    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public CategoriaPostDAO(){
        pegarConexao();
    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  CategoriaPostDAO");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... CategoriaPostDAO: ", e);
        }
    }

    @Override
    public void insert(CategoriaPost categoriaPost) {
        try{
            PreparedStatement sql = conexao.prepareStatement("INSERT INTO categoriapost (id_post, id_categoria) " +
                    "VALUES (?, ?)");

            sql.setInt(1, categoriaPost.getIdPost());
            sql.setInt(2, categoriaPost.getIdCategoria());

            sql.executeUpdate();
            System.out.println("Conectado... insert CategoriaPostDAO");
            sql.close();

        } catch(SQLException e) {
            System.out.println("Erro de conexão... insert CategoriaPostDAO");
            e.printStackTrace();
        }




    }

    @Override
    public List<CategoriaPost> findByIdPost(int idPost) {
        List<CategoriaPost> cp = new ArrayList();

        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM categoriapost WHERE id_post = ?");
            sql.setInt(1, idPost);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findByIdPost CategoriaPostDAO");

            while(rs.next()) {
                CategoriaPost novo = new CategoriaPost();
                novo.setIdPost(rs.getInt("id_post"));
                novo.setIdCategoria(rs.getInt("id_categoria"));
                cp.add(novo);
            }
            return cp;

        } catch(SQLException e) {
            System.out.println("Erro de conexão... findByIdPost CategoriaPostDAO");
            e.printStackTrace();
        }
        return null;
    }
}
