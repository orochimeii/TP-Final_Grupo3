package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.ICiudadanoDAO;
import ar.edu.unju.fi.service.ICiudadanoService;
@Service
public class CiudadanoServiceImp implements ICiudadanoService {
	
	@Autowired
	private ICiudadanoDAO ciudadanoDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Ciudadano findByDni(String dni) {
		return ciudadanoDao.findByDni(Long.parseLong(dni));
	}

	@Override
	public Ciudadano registrar(Ciudadano ciudadano) {
		//LOGGER.info(ciudadano.getDni());
		ciudadano.setContrasenia(passwordEncoder.encode(ciudadano.getContrasenia()));
		ciudadanoDao.save(ciudadano);
		return ciudadano;
	}

	@Override
	public List<Ciudadano> getCiudadanos() {
		return ciudadanoDao.findAll();
	}

}
