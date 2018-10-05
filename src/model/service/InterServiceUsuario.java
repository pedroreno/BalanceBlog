package model.service;

import model.Usuario;

public interface InterServiceUsuario {
    public Usuario insert(Usuario usuario);
    public Usuario findByNome(String nome);
}
