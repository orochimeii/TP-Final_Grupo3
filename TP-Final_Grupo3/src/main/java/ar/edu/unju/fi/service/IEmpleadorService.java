package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleador;

public interface IEmpleadorService {
	public Empleador findByCuit(String cuit);
	public Empleador registrar(Empleador empleador);
	public List<Empleador> getEmpleadores();
}
