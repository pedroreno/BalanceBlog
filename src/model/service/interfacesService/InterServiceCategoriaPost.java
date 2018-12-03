package model.service.interfacesService;

import model.CategoriaPost;

import java.util.List;

public interface InterServiceCategoriaPost {
    void insert(CategoriaPost categoriaPost);
    List<CategoriaPost> findByIdPost(int idPost);
}
