package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
	@Id
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DNI")
	private int dni;
	
	@Column(name = "TRAMITE_NUMERO")
	private int numeroDeTramite;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "PROVINCIA")
	private String privincia;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "TELEFONO")
	private String telefono;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaDeNacimiento;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ciudadano_oferta", 
				joinColumns = {@JoinColumn(name = "ciudadano_Id")}, 
				inverseJoinColumns = {@JoinColumn(name = "oferta_id")})
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	public Ciudadano(int dni, int numeroDeTramite, String email, String estadoCivil, String privincia, String telefono,
			LocalDate fechaDeNacimiento, String contrasenia) {
		super();
		this.dni = dni;
		this.numeroDeTramite = numeroDeTramite;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.privincia = privincia;
		this.telefono = telefono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.contrasenia = contrasenia;
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
	public String getcontrasenia() {
		return contrasenia;
	}
	public void setcontrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
