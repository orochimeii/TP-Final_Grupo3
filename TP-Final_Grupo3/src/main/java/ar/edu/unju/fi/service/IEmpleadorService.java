package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleador;

public interface IEmpleadorService {
	public Empleador findByEmail(String email);
	public Empleador registrar(Empleador empleador);
	public List<Empleador> getEmpleadores();
}
