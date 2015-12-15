
package es.uc3m.tiw.model;

import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;


@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
		private Integer idusuarios;
		private String usuario;	
		private String clave;
		private String nombre;
		private String apellidos;
		private int edad;
		private int rol;
		private String email;
		private String telefono;
		private String direccion;
		private String descripcion;
		private String intereses;
		private long numeroTarjeta;
		private String expiracion;
		private int codigoCVC;
		//public String imagenuri;
		//public ArrayList<Curso> Listacursos= new ArrayList<Curso>();
		
			@ManyToMany
			private List <Curso> ListaCursosAlumno =new ArrayList <Curso>();
			
			@OneToMany(mappedBy="Profesor")
			private List <Curso> ListaCursosProfesor =new ArrayList <Curso>();

			public List<Curso> getListaCursosAlumno() {
				return ListaCursosAlumno;
			}

			public void setListaCursosAlumno(List<Curso> listaCursosAlumno) {
				ListaCursosAlumno = listaCursosAlumno;
			}
			

			public List<Curso> getListaCursosProfesor() {
				return ListaCursosProfesor;
			}

			public void setListaCursosProfesor(List<Curso> listaCursosProfesor) {
				ListaCursosProfesor = listaCursosProfesor;
			}
			
			
			/*public static List<Curso> Matricular (Curso curso){ //le paso el id del curso
				//tengo su lista de cursos
				List <Curso> ListaCursos =new ArrayList <Curso>();
				//Se lo añado
				 ListaCursos.add(curso);
				return ListaCursos;
			}*/

/*@Id
@GeneratedValue(strategy = AUTO)
private Long id;
@Column(unique = true)
private String nombre;
@Column(nullable = true)
private String apellidos;

@Column(unique = true, nullable = false, length = 10)
private String nick;
@Column(nullable = false, length = 10)
private String password;

@OneToOne(cascade = ALL)
private Direccion direcc*/
		
		
		
		/*public boolean AddCurso(Curso curso){
	        boolean encontrado=false;
	        if(UsuarioCurso.size()==0){
	            UsuarioCurso.add(curso);
	        }else{
	            for (Curso curso1: UsuarioCurso){
	                if(curso==curso1){
	                encontrado=true;    
	                }
	            }
	            if(encontrado==false){
	                UsuarioCurso.add(curso);
	            }
	        }
	        return !encontrado;
	    } */
		
		
		/*public String getImagenuri() {
			return imagenuri;
		}



		public void setImagenuri(String imagenuri) {
			this.imagenuri = imagenuri;
		}*/



		/*public ArrayList<Curso> getUsuarioCurso() {
			return UsuarioCurso;
		}



		public  void setUsuarioCurso(ArrayList<Curso> usuarioCurso) {
			UsuarioCurso = usuarioCurso;
		}



		public  ArrayList<Curso> UsuarioCurso = new ArrayList<Curso>(); */
		
		public Usuario (){
			
		}

		public Usuario(int idusuarios, String usuario, String clave, String nombre,
				String apellidos,int edad, int rol, String email, String telefono, String direccion,
				String descripcion, String intereses,int numeroTarjeta,String expiracion,int codigoCVC, String imagenuri) {
			//Para cuando quiera meter todos los parametros de una vez
			super();
			this.idusuarios = idusuarios;
			this.usuario = usuario;
			this.clave = clave;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
			this.rol = rol;
			this.email = email;
			this.telefono = telefono;
			this.direccion = direccion;
			this.descripcion = descripcion;
			this.intereses = intereses;
			this.numeroTarjeta = numeroTarjeta;
			this.expiracion = expiracion;
			this.codigoCVC = codigoCVC;
			//this.imagenuri = imagenuri;
		}
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub


		}


		public int getIdusuarios() {
			return idusuarios;
		}



		public void setIdusuarios(int idusuarios) {
			this.idusuarios = idusuarios;
		}
		
		
		public String getUsuario() {
			return usuario;
		}



		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}



		public String getClave() {
			return clave;
		}



		public void setClave(String clave) {
			this.clave = clave;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getApellidos() {
			return apellidos;
		}



		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}



		public int getEdad() {
			return edad;
		}



		public void setEdad(int edad) {
			this.edad = edad;
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



		public String getDireccion() {
			return direccion;
		}



		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}



		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}



		public String getIntereses() {
			return intereses;
		}



		public void setIntereses(String intereses) {
			this.intereses = intereses;
		}



		public long getNumeroTarjeta() {
			return numeroTarjeta;
		}



		public void setNumeroTarjeta(long numeroTarjeta) {
			this.numeroTarjeta = numeroTarjeta;
		}



		public String getExpiracion() {
			return expiracion;
		}



		public void setExpiracion(String expiracion) {
			this.expiracion = expiracion;
		}



		public int getCodigoCVC() {
			return codigoCVC;
		}



		public void setCodigoCVC(int codigoCVC) {
			this.codigoCVC = codigoCVC;
		}



		public int getRol() {
			return rol;
		}



		public void setRol(int rol) {
			this.rol = rol;
		}

		public boolean EstaMatriculado (int id){
			
			for (int i = 0; i < ListaCursosAlumno.size(); i++) {
				if(ListaCursosAlumno.get(i).getIdcursos().equals(id)){
					return true;
				}
				
			}
			return false;
		}

	/*@Override
	public String toString() {
		
		return super.toString()+" Usuario [" + (rol != null ? "rol=" + rol : "") + "]";
	}*/

}