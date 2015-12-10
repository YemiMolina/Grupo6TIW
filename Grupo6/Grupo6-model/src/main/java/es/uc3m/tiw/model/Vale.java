package es.uc3m.tiw.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Usuario;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="vales")
@NamedQuery(name="vales.findAll", query="SELECT v FROM Vale v")
public class Vale implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	@Temporal(TemporalType.DATE)
	private Date FechaCaducidad;
	private String nombre;
	private long cantidad;
	private Usuario profesor;
	private Integer numeroCursosinscrito;
	private double numeroMinMatricula;
	@Temporal(TemporalType.DATE)
	private Date FechaMaxima;
	
	
	public Integer getNumeroCursosinscrito() {
		return numeroCursosinscrito;
	}
	public void setNumeroCursosinscrito(Integer numeroCursosinscrito) {
		this.numeroCursosinscrito = numeroCursosinscrito;
	}
	public double getNumeroMinMatricula() {
		return numeroMinMatricula;
	}
	public void setNumeroMinMatricula(double numeroMinMatricula) {
		this.numeroMinMatricula = numeroMinMatricula;
	}
	public Date getFechaMaxima() {
		return FechaMaxima;
	}
	public void setFechaMaxima(Date fechaMaxima) {
		FechaMaxima = fechaMaxima;
	}
	public Usuario getProfesor() {
		return profesor;
	}
	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaCaducidad() {
		return FechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		FechaCaducidad = fechaCaducidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getDateString(){
	String fechaCaducidad = new SimpleDateFormat("yyyy-MM-dd").format(FechaCaducidad);
	return fechaCaducidad;
	}
}
