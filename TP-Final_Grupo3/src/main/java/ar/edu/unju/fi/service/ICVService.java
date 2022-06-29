package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.CV;

public interface ICVService {
	
	public CV crearCV();
	public void guardarCV(CV cv);
	public void eliminarCV(long id);
	public List<CV> obtenerCVs();
	public CV buscarCV(long id);
}
