package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.CursoRepository;
import ar.edu.unju.fi.service.ICursoService;

@Service
public class CursoServiceImp implements ICursoService {

	@Autowired
	CursoRepository cursoRepository;
	
	@Override
	public List<Curso> obtenerCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso buscarCurso(Long id) {
		return cursoRepository.findById(id).get();
	}

}
