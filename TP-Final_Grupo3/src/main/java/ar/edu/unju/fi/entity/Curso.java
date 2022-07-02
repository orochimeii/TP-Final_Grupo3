package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "FECHA_INICIO")
	private LocalDate fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private LocalDate fechaFin;
	
	@Column(name = "CANTIDAD_HORAS")
	private int cantidadHoras;
	
	@Column(name = "MODALIDAD")
	private String modalidad;
	
	@Column(name = "DOCENTE")
	private String docente;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public Curso(String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int cantidadHoras,
			String modalidad, String docente) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad
				+ ", docente=" + docente + "]";
	}
}
