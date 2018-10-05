package model.dao.interfacesDAO;

import model.Usuario;

import java.util.List;

public interface InterUsuarioDAO {
    public Usuario insert(Usuario usuario);
    public Usuario findById(Long id);
    public Usuario findByName(String nome);
    public List<Usuario> findAll();
    public Usuario update(Usuario usuAnt, Usuario usuAt);
    public boolean delete(Usuario usuario);
    public boolean delete(Long id);
}
