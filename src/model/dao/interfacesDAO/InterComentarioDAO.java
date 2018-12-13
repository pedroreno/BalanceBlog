package model.dao.interfacesDAO;

import model.Comentario;

import java.util.List;

public interface InterComentarioDAO {
    void insert(Comentario comentario);
    Comentario findById(int id);
    List<Comentario> findByUsuarioID(int idUsuario);
    List<Comentario> findByPostID(int idPost);
    List<Comentario> findByUsuarioPost(int idUsuario, int idPost);
    void deleteByUsuario(int idUsuario);
    void deleteById(int idPost);
}
