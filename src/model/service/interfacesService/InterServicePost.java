package model.service.interfacesService;

import model.Post;

import java.util.List;

public interface InterServicePost {
    void insert(Post post);
    Post findByTitulo(String titulo);
    Post findById(int idPost);
    List<Post> findAll();
    void deleteByID(int idPost);
    void deleteByTitulo(String tituloPost);
}
