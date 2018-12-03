package model.dao.interfacesDAO;

import model.Categoria;

import java.util.List;

public interface InterCategoriaDAO {
    Categoria findByName(String nome);
    Categoria findById(int idCategoria);
}
