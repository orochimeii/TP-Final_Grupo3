package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "curriculums")
public class CV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	//Informacion del contacto
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "NOMBRE")
	private String nombre;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "APELLIDO")
	private String apellido;
	
	@NotNull(message="Este campo no puede ser vacío")
	@Min(value=1000000, message="El DNI debe ser mayor a 1000000")
	@Column(name = "DNI")
	private int dni;
	
	@NotNull(message="Este campo no puede ser vacío")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;
	
	// Donde vive
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
		
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "PROVINCIA")
	private String provincia;
		
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DOMICILIO")
	private String domicilio;
	
	// Contacto
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "EMAIL")
	private String email;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "TELEFONO")
	private String telefono;
	
	//Experiencia Laboral
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "ESTABLECIMIENTO")
	private String establecimiento;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DURACION")
	private String duracion;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "PUESTO")
	private String puesto;
	
	// Educacion
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "SECUNDARIA") 
	private String secundaria;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "TITULO_SECUNDARIO") 
	private String titulo_secundaria;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "UNIVERSIDAD") 
	private String universidad;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "TITULO_UNIVERSITARIO") 
	private String titulo_universitario;
	
	// Habilidades
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "IDIOMAS") 
	private String idiomas;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "CONOCIMIENTOS_INFORMATICOS")
	private String conocimientosInformaticos;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "INFORMACION_COMPLEMENTARIA") 
	private String informacionComplementaria;
	
	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DATOS_ADICIONALES")
	private String datosAdicionales;
	
	@OneToOne(mappedBy = "curriculumVitae")
	private Ciudadano ciudadano;
	
	public CV() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getSecundaria() {
		return secundaria;
	}

	public void setSecundaria(String secundaria) {
		this.secundaria = secundaria;
	}

	public String getTitulo_secundaria() {
		return titulo_secundaria;
	}

	public void setTitulo_secundaria(String titulo_secundaria) {
		this.titulo_secundaria = titulo_secundaria;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getTitulo_universitario() {
		return titulo_universitario;
	}

	public void setTitulo_universitario(String titulo_universitario) {
		this.titulo_universitario = titulo_universitario;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getConocimientosInformaticos() {
		return conocimientosInformaticos;
	}

	public void setConocimientosInformaticos(String conocimientosInformaticos) {
		this.conocimientosInformaticos = conocimientosInformaticos;
	}

	public String getInformacionComplementaria() {
		return informacionComplementaria;
	}

	public void setInformacionComplementaria(String informacionComplementaria) {
		this.informacionComplementaria = informacionComplementaria;
	}

	public String getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public CV(String nombre, String apellido,int dni,LocalDate fechaNacimiento,String nacionalidad,
			String provincia, String domicilio, String email, String telefono, String establecimiento,
			String duracion, String puesto, String secundaria, String titulo_secundaria,
			String universidad, String titulo_universitario, String idiomas, String conocimientosInformaticos,
			String informacionComplementaria, String datosAdicionales, Ciudadano ciudadano) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.provincia = provincia;
		this.domicilio = domicilio;
		this.email = email;
		this.telefono = telefono;
		this.establecimiento = establecimiento;
		this.duracion = duracion;
		this.puesto = puesto;
		this.secundaria = secundaria;
		this.titulo_secundaria = titulo_secundaria;
		this.universidad = universidad;
		this.titulo_universitario = titulo_universitario;
		this.idiomas = idiomas;
		this.conocimientosInformaticos = conocimientosInformaticos;
		this.informacionComplementaria = informacionComplementaria;
		this.datosAdicionales = datosAdicionales;
		this.ciudadano = ciudadano;
	}

	@Override
	public String toString() {
		return "CV [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", nacionalidad=" + nacionalidad + ", provincia=" + provincia + ", domicilio="
				+ domicilio + ", email=" + email + ", telefono=" + telefono + ", establecimiento=" + establecimiento
				+ ", duracion=" + duracion + ", puesto=" + puesto + ", secundaria=" + secundaria
				+ ", titulo_secundaria=" + titulo_secundaria + ", universidad=" + universidad
				+ ", titulo_universitario=" + titulo_universitario + ", idiomas=" + idiomas
				+ ", conocimientosInformaticos=" + conocimientosInformaticos + ", informacionComplementaria="
				+ informacionComplementaria + ", datosAdicionales=" + datosAdicionales + ", ciudadano=" + ciudadano
				+ "]";
	}
	
	
}
