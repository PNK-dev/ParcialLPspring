package pe.edu.upeu.parciallp.dao;

import java.util.List;

import pe.edu.upeu.parciallp.entity.Facultad;

public interface FacultadDao {
	Facultad create(Facultad f);
	Facultad update(Facultad f);
	void delete(Long id);
	Facultad read(Long id);
	List<Facultad>readAll();
}
