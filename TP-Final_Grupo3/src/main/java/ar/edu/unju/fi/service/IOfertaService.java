package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaService {
	public List<Oferta> getOfertas();
	public Oferta crear(Oferta oferta);
}
