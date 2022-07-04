package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
	@Id
	@NotNull
	@Column(name = "DNI", nullable = false)
	private Long dni;
	
	@NotNull
	@Column(name = "TRAMITE_NUMERO")
	private int numeroDeTramite;
	
	@NotEmpty
	@Column(name = "EMAIL")
	private String email;
	
	@NotEmpty
	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;
	
	@NotEmpty
	@Column(name = "PROVINCIA")
	private String privincia;
	
	@NotEmpty
	@Column(name = "TELEFONO")
	private String telefono;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaDeNacimiento ;
	
	@NotEmpty
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ciudadano_oferta", 
				joinColumns = {@JoinColumn(name = "ciudadano_Id")}, 
				inverseJoinColumns = {@JoinColumn(name = "oferta_id")})
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_CV")
	private CV curriculumVitae;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="ciudadano_curso",
				joinColumns = @JoinColumn(name = "ciudadano_id"),
				inverseJoinColumns = @JoinColumn(name = "curso_id")
			)
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public Ciudadano(Long dni, int numeroDeTramite, String email, String estadoCivil, String privincia, String telefono,
			LocalDate fechaDeNacimiento, String contrasenia, List<Oferta> ofertas, CV curriculumVitae) {

		super();
		this.dni = dni;
		this.numeroDeTramite = numeroDeTramite;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.privincia = privincia;
		this.telefono = telefono;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.contrasenia = contrasenia;
		this.curriculumVitae = curriculumVitae;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
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
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public CV getCv() {
		return curriculumVitae;
	}
	public void setCv(CV curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
