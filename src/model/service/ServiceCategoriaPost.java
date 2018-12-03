package model.service;

import model.Categoria;
import model.CategoriaPost;
import model.dao.CategoriaPostDAO;
import model.dao.interfacesDAO.InterCategoriaPostDAO;
import model.service.interfacesService.InterServiceCategoriaPost;

import java.sql.SQLException;
import java.util.List;

public class ServiceCategoriaPost implements InterServiceCategoriaPost {
    @Override
    public List<CategoriaPost> findByIdPost(int idPost) {
        InterCategoriaPostDAO cpDAO = new CategoriaPostDAO();
        List<CategoriaPost> lista = cpDAO.findByIdPost(idPost);
        return lista;
    }

    @Override
    public void insert(CategoriaPost categoriaPost) {
        InterCategoriaPostDAO cpDAO = new CategoriaPostDAO();
        cpDAO.insert(categoriaPost);


    }
}
