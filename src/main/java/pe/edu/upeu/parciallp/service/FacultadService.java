package pe.edu.upeu.parciallp.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.parciallp.entity.Facultad;

public interface FacultadService {
	Facultad create(Facultad f);
	Facultad update(Facultad f);
	void delete(Long id);
	Optional<Facultad>read(Long id);
	List<Facultad>readAll();
}
