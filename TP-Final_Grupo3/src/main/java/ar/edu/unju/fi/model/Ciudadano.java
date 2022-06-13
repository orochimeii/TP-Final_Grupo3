package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Ciudadano {
	private int dni;
	private int numeroDeTramite;
	private String email;
	private String estadoCivil;
	private String privincia;
	private String telefono;
	private LocalDate fechaDeNacimiento;
	private String consenia;
	
	public Ciudadano(int dni, int numeroDeTramite, String email, String estadoCivil, String privincia, String telefono,
			LocalDate fechaDeNacimiento, String consenia) {
		super();
		this.dni = dni;
		this.numeroDeTramite = numeroDeTramite;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.privincia = privincia;
		this.telefono = telefono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.consenia = consenia;
	}
	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getNumeroDeTramite() {
		return numeroDeTramite;
	}
	public void setNumeroDeTramite(int numeroDeTramite) {
		this.numeroDeTramite = numeroDeTramite;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getPrivincia() {
		return privincia;
	}
	public void setPrivincia(String privincia) {
		this.privincia = privincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getConsenia() {
		return consenia;
	}
	public void setConsenia(String consenia) {
		this.consenia = consenia;
	}
}
