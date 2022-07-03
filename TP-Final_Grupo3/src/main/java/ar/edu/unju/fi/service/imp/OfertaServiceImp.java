package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.service.IOfertaService;
@Service
public class OfertaServiceImp implements IOfertaService {

	@Autowired
	private IOfertaDAO ofertaDao;
	
	@Override
	public List<Oferta> getOfertas() {
		// TODO Auto-generated method stub
		return ofertaDao.findAll();
	}

	@Override
	public Oferta crear(Oferta oferta) {
		// TODO Auto-generated method stub
		return ofertaDao.save(oferta);
	}

}
