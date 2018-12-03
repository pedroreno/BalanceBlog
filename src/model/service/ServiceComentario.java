package model.service;

import model.Comentario;
import model.dao.ComentarioDAO;
import model.dao.interfacesDAO.InterComentarioDAO;
import model.service.interfacesService.InterServiceComentario;

public class ServiceComentario implements InterServiceComentario {
    @Override
    public void insert(Comentario comentario) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        icDAO.insert(comentario);
    }

    @Override
    public Comentario findById(int id) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        Comentario comentario = icDAO.findById(id);
        return comentario;
    }

    @Override
    public Comentario[] deleteByUsuario(String usuario) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        Comentario[] comentarios = icDAO.deleteByUsuario(usuario);
        return comentarios;
    }

    @Override
    public Comentario[] findByUsuarioID(int id) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        Comentario[] comentarios = icDAO.findByUsuarioID(id);
        return comentarios;
    }

    @Override
    public Comentario[] findByPostID(int id) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        Comentario[] comentarios = icDAO.findByPostID(id);
        return comentarios;
    }

    @Override
    public Comentario[] findByUsuarioPost(int idUsuario, int idPost) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        Comentario[] comentarios = icDAO.findByUsuarioPost(idUsuario, idPost);
        return comentarios;
    }
}
