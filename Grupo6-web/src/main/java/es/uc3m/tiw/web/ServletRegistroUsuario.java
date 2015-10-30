package es.uc3m.tiw.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletRegistroUsuario
 */
@WebServlet("/ServletRegistroUsuario")
public class ServletRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public static ArrayList <Usuario> listaUsuarios;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistroUsuario() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Usuario alumno1 = new Usuario("borjita", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		Usuario alumno2 = new Usuario("carlos", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		Usuario profesor1 = new Usuario("profe", "pass1", "Borja", "Perez", 21,2,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(alumno1);
		listaUsuarios.add(alumno2);
		listaUsuarios.add(profesor1);	
	
		
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		Integer edad = Integer.valueOf(request.getParameter("edad"));
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String descripcion = request.getParameter("descripcion");
		String intereses = request.getParameter("intereses");
		long numeroTarjeta = Long.valueOf(request.getParameter("numeroTarjeta"));
		String expiracion = request.getParameter("expiracion");
		Integer codigoCVC = Integer.valueOf(request.getParameter("codigoCVC"));
		
		//Creo un usuario con los atributos
		
		Usuario us1 = new Usuario();
		us1.setUsuario(usuario);
		us1.setClave(clave);
		us1.setNombre(nombre);
		us1.setApellidos(apellidos);
		us1.setEdad(edad);
		us1.setEmail(email);
		us1.setTelefono(telefono);
		us1.setDireccion(direccion);
		us1.setDescripcion(descripcion);
		us1.setIntereses(intereses);
		us1.setNumeroTarjeta(numeroTarjeta);
		us1.setExpiracion(expiracion);
		us1.setCodigoCVC(codigoCVC);
		
		listaUsuarios.add(us1);//añadir usuario a la lista de usuarios
		
		
		request.setAttribute("usuario", us1);
		/*request.setAttribute("clave", clave);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("edad", edad);
		request.setAttribute("email", email);
		request.setAttribute("telefono", telefono);
		request.setAttribute("direccion", direccion);
		request.setAttribute("descripcion", descripcion);
		request.setAttribute("intereses", intereses);
		request.setAttribute("numeroTarjeta", numeroTarjeta);
		request.setAttribute("expiracion", expiracion);
		request.setAttribute("codigoCVC", codigoCVC);*/
		
		request.setAttribute("listaUsuarios", listaUsuarios);

		
		//Pinta lo anterior en el jsp Perfil
		
		getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
		
	}
	
public static Usuario UsuarioActual(){
		
		Usuario Pepe= new Usuario();
		Pepe.setUsuario("usuario");
		Pepe.setNombre("Pepe");
		Pepe.setApellidos("Fernandez");
		Pepe.setEdad(31);
		Pepe.setEmail("email");
		Pepe.setTelefono("620105970");
		Pepe.setDireccion("Lopez de Hoyos");
		Pepe.setDescripcion("Chico");
		Pepe.setIntereses("Me gustan las matematicas");
		Pepe.setNumeroTarjeta(12345671234567l);
		Pepe.setExpiracion("12/12");
		Pepe.setCodigoCVC(123);
		
		return Pepe;
	}

	
public static String guardarImagen(Part filePart){
		
		Date date = new Date();
		String archivoNombre ="";
		
		if (filePart!=null && filePart.getSize()!= 0){
			archivoNombre= "imagen" + date.getTime();
		//donde se guardan las imagenes
		//lo va leyendo del Part y lo guarda en un lugar del disco
		try {
			FileOutputStream outputStream = new FileOutputStream("/home/tiw/fotos/" + archivoNombre);
			
			int read = 0;
			InputStream inputStream =filePart.getInputStream();
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		return archivoNombre;
	}

}
