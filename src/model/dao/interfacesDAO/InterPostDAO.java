package model.dao.interfacesDAO;

import model.Post;

import java.util.List;

public interface InterPostDAO {
    void insert(Post post);
    Post findById(int id);
    Post findByTitulo(String titulo);
    Post findByCategoria(String categoria);
    List<Post> findAll();
    Post update(Post postAnterior, Post postAtual);
    void deleteById(int idPost);
    void deleteByTitulo(String tituloPost);
}
