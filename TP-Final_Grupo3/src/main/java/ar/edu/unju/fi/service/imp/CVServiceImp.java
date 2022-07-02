package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.CV;
import ar.edu.unju.fi.repository.CVRepository;
import ar.edu.unju.fi.service.ICVService;

@Service
public class CVServiceImp implements ICVService {

	@Autowired
	CVRepository cvRepository;
	
	@Override
	public CV crearCV() {
		return new CV();
	}

	@Override
	public void guardarCV(CV cv) {
		cvRepository.save(cv);
	}

	@Override
	public void eliminarCV(long id) {
		cvRepository.deleteById(id);
	}

	@Override
	public List<CV> obtenerCVs() {
		return cvRepository.findAll();
	}

	@Override
	public CV buscarCV(long id) {
		return cvRepository.findById(id).get();
	}

}
