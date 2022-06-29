package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {
	
	public List<Curso> obtenerCursos();
	public Curso buscarCurso(Long id);
}
