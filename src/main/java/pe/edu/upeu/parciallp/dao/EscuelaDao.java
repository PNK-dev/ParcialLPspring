package pe.edu.upeu.parciallp.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.parciallp.entity.Escuela;

public interface EscuelaDao {
	Escuela create(Escuela e);
	Escuela update(Escuela e);
	void delete(Long id);
	Escuela read(Long id);
	List<Escuela>readAll();
}
