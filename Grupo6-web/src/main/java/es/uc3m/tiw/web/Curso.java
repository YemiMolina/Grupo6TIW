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
	public ArrayList<Usuario> ListaUsuarios= new ArrayList<Usuario>();
	
	//Funcion en la que el profesor se queda con el 70% del precio del curso
	private Double getSalarioProfesor(){
	double Salario= getPrecioFinal()*0.70;
	int numeroUsuarios=ListaUsuarios.size();
	double salarioTotal=numeroUsuarios*Salario;
	return salarioTotal;
	}
	
	
	public void AddUsuario(Usuario usuario){
		ListaUsuarios.add(usuario);
    } 
	
	
	public Curso(String titulo, String descripcion, String dificultad,
			int numeroh, double precio, String imagenuri, int id, double descuento) {
		//Para cuando quiera meter todos los parametros de una vez
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.dificultad = dificultad;
		this.numeroh = numeroh;
		this.precio = precio;
		this.imagenuri = imagenuri;
		this.id = id;
		this.descuento = descuento;
	}
	
	
	public ArrayList<Usuario> getListaUsuarios() {
		return ListaUsuarios;
	}


	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		ListaUsuarios = listaUsuarios;
	}


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

