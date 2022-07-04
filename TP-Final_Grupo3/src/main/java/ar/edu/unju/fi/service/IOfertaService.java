package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaService {
	public List<Oferta> getOfertas();
	public Oferta crear(Oferta oferta);
	public Optional<Oferta> findById(Long id);
	public Oferta update(Oferta oferta);
	public void eliminar(Long id);
}
