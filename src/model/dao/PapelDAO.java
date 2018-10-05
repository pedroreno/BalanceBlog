package model.dao;

import model.EnumPapeis;
import model.Papel;
import model.dao.interfacesDAO.InterPapelDAO;

import java.sql.*;
import java.util.List;

public class PapelDAO implements InterPapelDAO {

    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public PapelDAO(){
        pegarConexao();

    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  PapelDAO ...");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... PapelDAO: ", e);
        }
    }

    @Override
    public Papel insert(Papel papel) {
        return null;
    }

    @Override
    public Papel findById(Long id) {
        Papel papel = null;
        try {
            PreparedStatement sql = conexao.prepareStatement("select * from balanceBlog.papel where id = ?");
            sql.setString(1, id.toString());
            ResultSet rs = sql.executeQuery();
            rs.next();

            papel = new Papel();
            papel.setId(rs.getLong(1));
            papel.setDesc(EnumPapeis.valueOf(rs.getString(2)));

            sql.close();
            rs.close();
            conexao.close();

            return papel;

        } catch (Exception e) {
            System.out.println("\nErro de conexão ... PapelDAO findByID");
        }
        return papel;
    }

    @Override
    public Papel findByDesc(EnumPapeis desc) {
        return null;
    }

    @Override
    public List<Papel> findAll() {
        return null;
    }

    @Override
    public Papel update(Papel papelA, Papel N) {
        return null;
    }

    @Override
    public boolean delete(Papel papel) {
        return false;
    }
}
