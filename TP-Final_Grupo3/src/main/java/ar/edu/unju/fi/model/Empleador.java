package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Empleador {
	private int ciut;
	private String contrasenia;
	private String razonSocial;
	private String nombreComercial;
	private LocalDate inicioDeActividad;
	private String email;
	private String telefono;
	private String domicilio;
	private String provincia;
	private String paginaWeb;
	private String descripcion;
	
	public Empleador(int ciut, String contrasenia, String razonSocial, String nombreComercial,
			LocalDate inicioDeActividad, String email, String telefono, String domicilio, String provincia,
			String paginaWeb, String descripcion) {
		super();
		this.ciut = ciut;
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
	
	public int getCiut() {
		return ciut;
	}
	public void setCiut(int ciut) {
		this.ciut = ciut;
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
