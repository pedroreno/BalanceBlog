package model.service;

import model.Papel;
import model.Usuario;
import model.dao.PapelDAO;
import model.dao.PapelUsuarioDAO;
import model.dao.UsuarioDAO;
import model.dao.interfacesDAO.InterPapelDAO;
import model.dao.interfacesDAO.InterPapelUsuarioDAO;
import model.dao.interfacesDAO.InterUsuarioDAO;

import java.util.ArrayList;
import java.util.List;

public class ServiceUsuario implements InterServiceUsuario {
    @Override
    public Usuario insert(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario findByNome(String nome) {
        InterUsuarioDAO uDAO = new UsuarioDAO();
        InterPapelUsuarioDAO upDAO = new PapelUsuarioDAO();
        InterPapelDAO pDAO = new PapelDAO();
        Usuario usuario = uDAO.findByName(nome);
        List<Long> idPapeis = upDAO.findByUsuario(usuario);
        List<Papel> papeis = new ArrayList();

        for(Long id:idPapeis) {
            papeis.add(pDAO.findById(id));
        }
        usuario.setPapeis(papeis);
        return usuario;
    }
}
