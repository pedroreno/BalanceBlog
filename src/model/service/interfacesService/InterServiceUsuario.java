package model.service.interfacesService;

import model.Usuario;

import java.util.List;

public interface InterServiceUsuario {
    void insert(Usuario usuario);
    Usuario findByName(String nome);
    Usuario findById(int idUsuario);
    List<Usuario> findAll();
    void deleteById(int idUsuario);
    void deleteByName(String nomeUsuario);
}
