package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.service.IEmpleadorService;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class EmpladorServiceImp implements IEmpleadorService {
	private static final Log LOGGER = LogFactory.getLog(EmpladorServiceImp.class);
	
	@Autowired
	private IEmpleadorDAO empleadorDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Empleador findByCuit(String cuit) {
		return empleadorDao.findByCuit(Long.parseLong(cuit));
	}

	@Override
	public Empleador registrar(Empleador empleador) {
		LOGGER.info(empleador.getcuit());
		empleador.setContrasenia(passwordEncoder.encode(empleador.getContrasenia()));
		empleadorDao.save(empleador);
		return empleador;
	}

	@Override
	public List<Empleador> getEmpleadores() {
		return empleadorDao.findAll();
	}

}
