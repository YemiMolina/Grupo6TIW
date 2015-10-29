package es.uc3m.tiw.web;

import java.util.ArrayList;

public class Curso {
	private String titulo;
	private String descripcion;
	private String dificultad;
	private int numeroh;
	private double precio;
	private String imagenuri;
	private int id;
	private double descuento;
	
	
	public double getPrecioFinal(){
		return precio-descuento;
	}
	
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private ArrayList<Leccion> ListaLecciones= new ArrayList <Leccion>();
	
	
	public ArrayList<Leccion> getListaLecciones() {
		return ListaLecciones;
	}
	public void setListaLecciones(ArrayList<Leccion> listaLecciones) {
		ListaLecciones = listaLecciones;
	}
	public String getImagenuri() {
		return imagenuri;
	}
	public void setImagenuri(String imagenuri) {
		this.imagenuri = imagenuri;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public int getNumeroh() {
		return numeroh;
	}
	public void setNumeroh(int numeroh) {
		this.numeroh = numeroh;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}

