package model.dao.interfacesDAO;

import model.Papel;
import model.Usuario;

import java.util.List;

public interface InterPapelUsuarioDAO {
    public List<Long> findByUsuario(Usuario user);
    public List<Long> findByPapel(Papel papel);

}
