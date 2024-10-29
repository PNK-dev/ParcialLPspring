package pe.edu.upeu.parciallp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.parciallp.entity.Escuela;
import pe.edu.upeu.parciallp.repository.EscuelaRepository;
import pe.edu.upeu.parciallp.service.EscuelaService;

@Service
public class EscuelaServiceImpl implements EscuelaService{
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
	public Optional<Escuela> read(Long id) {
		// TODO Auto-generated method stub
		return escuelaRepository.findById(id);
	}

	@Override
	public List<Escuela> readAll() {
		// TODO Auto-generated method stub
		return escuelaRepository.findAll();
	}

}
