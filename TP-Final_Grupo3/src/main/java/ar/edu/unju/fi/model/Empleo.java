package ar.edu.unju.fi.model;

import java.util.ArrayList;

public class Empleo {
	private int cantidadDeVacantes;
	private String puestoRequerido;
	private String resumenPuesto;
	private String disponibilidad;
	private ArrayList <String> tareasPrincipales;
	private ArrayList <String> datosContacto;
	private String jornada;
	private String requisitos;
	private double salario;
	private String beneficios;
	private boolean disponible;
	
	public Empleo(int cantidadDeVacantes, String puestoRequerido, String resumenPuesto, String disponibilidad,
			ArrayList<String> tareasPrincipales, ArrayList<String> datosContacto, String jornada, String requisitos,
			double salario, String beneficios, boolean disponible) {
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
	}
	
	public Empleo() {
		super();
		// TODO Auto-generated constructor stub
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
}
