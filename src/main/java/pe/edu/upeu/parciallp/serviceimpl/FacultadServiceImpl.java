package pe.edu.upeu.parciallp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.parciallp.dao.FacultadDao;
import pe.edu.upeu.parciallp.entity.Facultad;
import pe.edu.upeu.parciallp.service.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService{
	@Autowired
	private FacultadDao facultadDao;
	@Override
	public Facultad create(Facultad f) {
		// TODO Auto-generated method stub
		return facultadDao.create(f);
	}

	@Override
	public Facultad update(Facultad f) {
		// TODO Auto-generated method stub
		return facultadDao.update(f);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facultadDao.delete(id);
	}

	@Override
	public Facultad read(Long id) {
		// TODO Auto-generated method stub
		return facultadDao.read(id);
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return facultadDao.readAll();
	}

}
