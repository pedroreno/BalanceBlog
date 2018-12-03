package model.service.interfacesService;

import model.Categoria;

import java.util.List;

public interface InterServiceCategoria {
    Categoria findByName(String nome);
    Categoria findById(int idPost);

}
