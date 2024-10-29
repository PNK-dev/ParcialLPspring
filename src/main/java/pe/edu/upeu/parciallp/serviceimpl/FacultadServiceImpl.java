package pe.edu.upeu.parciallp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.parciallp.entity.Facultad;
import pe.edu.upeu.parciallp.repository.FacultadRepository;
import pe.edu.upeu.parciallp.service.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService{
	@Autowired
	private FacultadRepository facultadRepository;

	@Override
	public Facultad create(Facultad f) {
		// TODO Auto-generated method stub
		return facultadRepository.save(f);
	}

	@Override
	public Facultad update(Facultad f) {
		// TODO Auto-generated method stub
		return facultadRepository.save(f);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facultadRepository.deleteById(id);
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return facultadRepository.findAll();
	}

	@Override
	public Optional<Facultad> read(Long id) {
		// TODO Auto-generated method stub
		return facultadRepository.findById(id);
	}
}
