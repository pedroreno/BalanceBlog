package model.service;

import model.Comentario;
import model.dao.ComentarioDAO;
import model.dao.interfacesDAO.InterComentarioDAO;
import model.service.interfacesService.InterServiceComentario;

import java.util.List;

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
    public List<Comentario> findByUsuarioID(int id) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        List<Comentario> comentarios = icDAO.findByUsuarioID(id);
        return comentarios;
    }

    @Override
    public List<Comentario> findByPostID(int id) {
        InterComentarioDAO cDAO = new ComentarioDAO();
        List<Comentario> comentarios = cDAO.findByPostID(id);
        return comentarios;
    }

    @Override
    public List<Comentario> findByUsuarioPost(int idUsuario, int idPost) {
        InterComentarioDAO icDAO = new ComentarioDAO();
        List<Comentario> comentarios = icDAO.findByUsuarioPost(idUsuario, idPost);
        return comentarios;
    }

    @Override
    public void deleteByUsuario(int idUsuario) {
        InterComentarioDAO cDAO = new ComentarioDAO();
        cDAO.deleteByUsuario(idUsuario);
    }

    @Override
    public void deleteById(int idComentario) {
        InterComentarioDAO cDAO = new ComentarioDAO();
        cDAO.deleteById(idComentario);
    }
}
