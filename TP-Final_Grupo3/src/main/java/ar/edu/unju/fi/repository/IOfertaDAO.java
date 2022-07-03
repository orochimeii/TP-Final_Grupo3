package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaDAO extends JpaRepository<Oferta, Long>{
	public Optional<Oferta> findById(Long id);
}
