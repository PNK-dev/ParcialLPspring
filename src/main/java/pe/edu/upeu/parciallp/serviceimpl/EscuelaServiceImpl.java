package pe.edu.upeu.parciallp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.parciallp.dao.EscuelaDao;
import pe.edu.upeu.parciallp.entity.Escuela;
import pe.edu.upeu.parciallp.service.EscuelaService;

@Service
public class EscuelaServiceImpl implements EscuelaService{
	@Autowired
	private EscuelaDao escuelaDao;
	@Override
	public Escuela create(Escuela e) {
		// TODO Auto-generated method stub
		return escuelaDao.create(e);
	}

	@Override
	public Escuela update(Escuela e) {
		// TODO Auto-generated method stub
		return escuelaDao.update(e);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		escuelaDao.delete(id);
	}

	@Override
	public Escuela read(Long id) {
		// TODO Auto-generated method stub
		return escuelaDao.read(id);
	}

	@Override
	public List<Escuela> readAll() {
		// TODO Auto-generated method stub
		return escuelaDao.readAll();
	}

}
