package model.dao;

import model.Papel;
import model.Usuario;
import model.dao.interfacesDAO.InterPapelUsuarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PapelUsuarioDAO implements InterPapelUsuarioDAO {

    Connection conexao;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/" +
            "balanceblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String USERNAME = "root";
    String PASSWORD = "1234";

    public PapelUsuarioDAO(){
        pegarConexao();

    }

    public void pegarConexao(){
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Conectado com sucesso...  PapelUsuarioDAO ...");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro de conexão... PapelUsuarioDAO: ", e);
        }
    }

    @Override
    public List<Long> findByUsuario(Usuario user) {
        List<Long> idPapeis = new ArrayList();
        try {
            PreparedStatement sql = conexao.prepareStatement("select * from balanceblog.papelusuario where id_usuario = ?");
            sql.setString(1, user.getId().toString());
            ResultSet rs = sql.executeQuery();
            while(rs.next()) {
                idPapeis.add(rs.getLong("id_papel"));
            }

            sql.close();
            rs.close();
            conexao.close();
            return idPapeis;

        } catch (Exception e) {
            System.out.println("\nErro de conexão... PapelUsuarioDAO findByUsuario");

        }
        return idPapeis;
    }

    @Override
    public List<Long> findByPapel(Papel papel) {
        return null;
    }
}
