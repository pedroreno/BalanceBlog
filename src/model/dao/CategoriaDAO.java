package model.dao;

import model.Categoria;
import model.dao.interfacesDAO.InterCategoriaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements InterCategoriaDAO {

    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public CategoriaDAO(){
        pegarConexao();
    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  CategoriaDAO");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... CategoriaDAO: ", e);
        }
    }

    @Override
    public Categoria findByName(String nome) {
        Categoria categoria;
        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM categoria WHERE nome_categoria = ?");
            sql.setString(1, nome);
            ResultSet rs = sql.executeQuery();
            System.out.println("Conectado... findByName CategoriaDAO");
            rs.next();

            if(!rs.first()) return null;
            else {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome_categoria"));

                rs.close();
                sql.close();

                return categoria;
            }
        } catch(SQLException e) {
            System.out.println("Erro de conexão... findByName CategoriaDAO");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Categoria findById(int idCategoria) {
        Categoria categoria = new Categoria();

        try {
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM categoria WHERE id_categoria = ?");
            sql.setInt(1, idCategoria);
            ResultSet rs = sql.executeQuery();
            rs.next();
            System.out.println("Conectado... findById CategoriaDAO");

            categoria.setId(rs.getInt("id_categoria"));
            categoria.setNome(rs.getString("nome_categoria"));

            rs.close();
            sql.close();

            return categoria;

        } catch(SQLException e) {
            System.out.println("Erro de conexão... findById CategoriaDAO");
            e.printStackTrace();
        }
        return null;
    }
}
