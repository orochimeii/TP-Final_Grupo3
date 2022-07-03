package ar.edu.unju.fi.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "ofertas")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
//	@Min(value=1, message="El valor mínimo es 1")
//	@Max(value=9999,message="El valor máximo permitido es 9999")
	@Column(name = "VACANTES")
	private int cantidadDeVacantes;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "PUESTO")
	private String puestoRequerido;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "RESUMEN")
	private String resumenPuesto;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DISPONIBILIDAD")
	private String disponibilidad;
	
	@Column(name = "TAREAS")
	private ArrayList <String> tareasPrincipales;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "CONTACTO")
	private ArrayList <String> datosContacto;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "JORNADA")
	private String jornada;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "REQUISITOS")
	private String requisitos;
	
	@Column(name = "SALARIO")
	private double salario;
	
	@Column(name = "BENEFICIOS")
	private String beneficios;
	
//	@NotEmpty(message="Este campo no puede ser vacío")
	@Column(name = "DISPONIBLE")
	private boolean disponible;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLEADOR_ID")
	Empleador empleador;
	
	public Oferta(int cantidadDeVacantes, String puestoRequerido, String resumenPuesto, String disponibilidad,
			ArrayList<String> tareasPrincipales, ArrayList<String> datosContacto, String jornada, String requisitos,
			double salario, String beneficios, boolean disponible, Empleador empleador) {
		super();
		this.cantidadDeVacantes = cantidadDeVacantes;
		this.puestoRequerido = puestoRequerido;
		this.resumenPuesto = resumenPuesto;
		this.disponibilidad = disponibilidad;
		this.tareasPrincipales = tareasPrincipales;
		this.datosContacto = datosContacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
		this.empleador = empleador;
	}
	
	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidadDeVacantes() {
		return cantidadDeVacantes;
	}
	public void setCantidadDeVacantes(int cantidadDeVacantes) {
		this.cantidadDeVacantes = cantidadDeVacantes;
	}
	public String getPuestoRequerido() {
		return puestoRequerido;
	}
	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}
	public String getResumenPuesto() {
		return resumenPuesto;
	}
	public void setResumenPuesto(String resumenPuesto) {
		this.resumenPuesto = resumenPuesto;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public ArrayList<String> getTareasPrincipales() {
		return tareasPrincipales;
	}
	public void setTareasPrincipales(ArrayList<String> tareasPrincipales) {
		this.tareasPrincipales = tareasPrincipales;
	}
	public ArrayList<String> getDatosContacto() {
		return datosContacto;
	}
	public void setDatosContacto(ArrayList<String> datosContacto) {
		this.datosContacto = datosContacto;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
}
