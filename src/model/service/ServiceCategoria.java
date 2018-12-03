package model.service;

import model.Categoria;
import model.dao.CategoriaDAO;
import model.dao.interfacesDAO.InterCategoriaDAO;
import model.service.interfacesService.InterServiceCategoria;

import java.util.List;

public class ServiceCategoria implements InterServiceCategoria {
    @Override
    public Categoria findByName(String nome) {
        InterCategoriaDAO cDAO = new CategoriaDAO();
        Categoria categoria = cDAO.findByName(nome);
        return categoria;
    }

    @Override
    public Categoria findById(int idPost) {
        InterCategoriaDAO cDAO = new CategoriaDAO();
        Categoria categoria = cDAO.findById(idPost);
        return categoria;
    }
}
