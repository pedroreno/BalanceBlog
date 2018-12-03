package model.service.interfacesService;

import model.Comentario;

public interface InterServiceComentario {
    public void insert(Comentario comentario);
    public Comentario findById(int id);
    public Comentario[] deleteByUsuario(String usuario);
    public Comentario[] findByUsuarioID(int id);
    public Comentario[] findByPostID(int id);
    public Comentario[] findByUsuarioPost(int idUsuario, int idPost);
}
