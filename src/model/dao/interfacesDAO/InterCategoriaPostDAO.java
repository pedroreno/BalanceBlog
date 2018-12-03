package model.dao.interfacesDAO;

import model.CategoriaPost;

import java.util.List;

public interface InterCategoriaPostDAO {
    void insert(CategoriaPost categoriaPost);
    List<CategoriaPost> findByIdPost(int idPost);
}
