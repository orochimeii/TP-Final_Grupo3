package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "empleadores")
public class Empleador {
	@Id
	//@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "CUIT")
	private Long cuit;
	
	//@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	
	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;
	
	//@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "NOMBRE_COMERCIAL")
	private String nombreComercial;
	
	@Column(name = "INICIO_ACTIVIDAD")
	private LocalDate inicioDeActividad;
	
	//@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "DOMICILO")
	private String domicilio;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "PAGINA_WEB")
	private String paginaWeb;
	
	//@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToMany(mappedBy = "empleador", cascade = CascadeType.ALL)
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public Empleador(Long cuit, String contrasenia, String razonSocial, String nombreComercial,
			LocalDate inicioDeActividad, String email, String telefono, String domicilio, String provincia,
			String paginaWeb, String descripcion, List<Oferta> ofertas) {
		super();
		this.cuit = cuit;
		this.contrasenia = contrasenia;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.inicioDeActividad = inicioDeActividad;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.paginaWeb = paginaWeb;
		this.descripcion = descripcion;
	}
	
	public Empleador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getcuit() {
		return cuit;
	}
	public void setcuit(Long cuit) {
		this.cuit = cuit;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public LocalDate getInicioDeActividad() {
		return inicioDeActividad;
	}
	public void setInicioDeActividad(LocalDate inicioDeActividad) {
		this.inicioDeActividad = inicioDeActividad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
