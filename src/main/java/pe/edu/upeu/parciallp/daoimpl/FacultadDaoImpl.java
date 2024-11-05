package pe.edu.upeu.parciallp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.parciallp.dao.FacultadDao;
import pe.edu.upeu.parciallp.entity.Facultad;
import pe.edu.upeu.parciallp.repository.FacultadRepository;

@Component
public class FacultadDaoImpl implements FacultadDao{
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
	public Facultad read(Long id) {
		// TODO Auto-generated method stub
		return facultadRepository.findById(id).get();
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return facultadRepository.findAll();
	}

}
