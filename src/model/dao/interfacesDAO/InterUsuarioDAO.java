package model.dao.interfacesDAO;

import model.Usuario;

import java.util.List;

public interface InterUsuarioDAO {
    Usuario insert(Usuario usuario);
    Usuario findById(int id);
    Usuario findByName(String nome);
    List<Usuario> findAll();
    Usuario update(Usuario usuAnterior, Usuario usuAtual);
    void deleteById(int idUsuario);
    void deleteByName(String nomeUsuario);
}
