package pe.edu.upeu.parciallp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.edu.upeu.parciallp.entity.Escuela;

public interface EscuelaService {
	Escuela create(Escuela e);
	Escuela update(Escuela e);
	void delete(Long id);
	Optional<Escuela>read(Long id);
	List<Escuela>readAll();
}
