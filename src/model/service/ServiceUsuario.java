package model.service;

import model.Usuario;
import model.dao.UsuarioDAO;
import model.dao.interfacesDAO.InterUsuarioDAO;
import model.service.interfacesService.InterServiceUsuario;

import java.util.List;

public class ServiceUsuario implements InterServiceUsuario {
    @Override
    public void insert(Usuario usuario) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        uDAO.insert(usuario);
    }

    @Override
    public Usuario findById(int idUsuario) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        Usuario user = uDAO.findById(idUsuario);
        return user;
    }

    @Override
    public Usuario findByName(String nome) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        Usuario usuario = uDAO.findByName(nome);
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        List<Usuario> usuarios = uDAO.findAll();
        return usuarios;
    }

    @Override
    public void deleteById(int idUsuario) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        uDAO.deleteById(idUsuario);
    }

    @Override
    public void deleteByName(String nomeUsuario) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        uDAO.deleteByName(nomeUsuario);
    }
}
