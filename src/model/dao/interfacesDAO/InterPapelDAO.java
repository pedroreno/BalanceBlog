package model.dao.interfacesDAO;

import model.EnumPapeis;
import model.Papel;

import java.util.List;

public interface InterPapelDAO {
    public Papel insert(Papel papel);
    public Papel findById(Long id);
    public Papel findByDesc(EnumPapeis desc);
    public List<Papel> findAll();
    public Papel update(Papel papelA, Papel N);
    public boolean delete(Papel papel);
}
