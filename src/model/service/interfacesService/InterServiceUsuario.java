package model.service.interfacesService;

import model.Usuario;

import java.util.List;

public interface InterServiceUsuario {
    void insert(Usuario usuario);
    Usuario findByName(String nome);
    List<Usuario> findAll();
    void deleteById(int idUsuario);
    void deleteByName(String nomeUsuario);
}
