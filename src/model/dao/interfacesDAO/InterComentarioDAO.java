package model.dao.interfacesDAO;

import model.Comentario;

public interface InterComentarioDAO {
    public void insert(Comentario comentario);
    public Comentario findById(int id);
    public Comentario[] deleteByUsuario(String usuario);
    public Comentario[] findByUsuarioID(int idUsuario);
    public Comentario[] findByPostID(int idPost);
    public Comentario[] findByUsuarioPost(int idUsuario, int idPost);
}
