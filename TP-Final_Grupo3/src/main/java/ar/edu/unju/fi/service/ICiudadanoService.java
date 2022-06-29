package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoService {
	public Ciudadano findByDni(String dni);
	public Ciudadano registrar(Ciudadano ciudadano);
	public List<Ciudadano> getCiudadanos();
}
