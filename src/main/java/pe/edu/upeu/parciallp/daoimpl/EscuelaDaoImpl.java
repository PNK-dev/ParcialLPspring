package pe.edu.upeu.parciallp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.parciallp.dao.EscuelaDao;
import pe.edu.upeu.parciallp.entity.Escuela;
import pe.edu.upeu.parciallp.repository.EscuelaRepository;

@Component
public class EscuelaDaoImpl implements EscuelaDao{
	@Autowired
	private EscuelaRepository escuelaRepository;
	@Override
	public Escuela create(Escuela e) {
		// TODO Auto-generated method stub
		return escuelaRepository.save(e);
	}

	@Override
	public Escuela update(Escuela e) {
		// TODO Auto-generated method stub
		return escuelaRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		escuelaRepository.deleteById(id);
	}

	@Override
	public Escuela read(Long id) {
		// TODO Auto-generated method stub
		return escuelaRepository.findById(id).get();
	}

	@Override
	public List<Escuela> readAll() {
		// TODO Auto-generated method stub
		return escuelaRepository.findAll();
	}

}
