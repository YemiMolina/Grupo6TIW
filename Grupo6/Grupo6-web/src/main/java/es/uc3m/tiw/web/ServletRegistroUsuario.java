package es.uc3m.tiw.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.UsuarioDAO;


/**
 * Servlet implementation class ServletRegistroUsuario
 */
@WebServlet("/ServletRegistroUsuario")
public class ServletRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String REGISTRO_JSP= "/Perfil.jsp";
	private static final String MODIFICADO_JSP= "/PerfilModificado.jsp";
	
	//public static ArrayList <Usuario> listaUsuarios;
	//private es.uc3m.tiw.model.Usuario us1;
	private List<Usuario> listaUsuarios;
	@PersistenceContext(unitName="Grupo6-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private UsuarioDAO dao;
	private ServletConfig config2;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		config2 = config;
		dao = new UsuarioDAO(em, ut);
		/*Usuario alumno1 = new Usuario("borjita", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "" );
		try {
			dao.createUsuario(alumno1);
		}catch (Exception e){
			e.printStackTrace();
		}*/
	}
	public void destroy (){
		dao=null;
	}
	
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

		HttpSession session = request.getSession();

		String accion = (String) request.getParameter("action");

		Usuario UsuarioMod = (Usuario) session.getAttribute("usuario"); 
		
		if (accion != null && accion.equals("modificar")) {

			request.setAttribute("UsuarioModificar", UsuarioMod);

			this.getServletConfig().getServletContext().getRequestDispatcher("/FormularioPerfilModificado.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


//		String pagina = "";
//		pagina= REGISTRO_JSP;
	
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		Integer edad = Integer.valueOf(request.getParameter("edad"));
		Integer rol = Integer.valueOf(request.getParameter("rol"));
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String descripcion = request.getParameter("descripcion");
		String intereses = request.getParameter("intereses");
		long numeroTarjeta = Long.valueOf(request.getParameter("numeroTarjeta"));
		String expiracion = request.getParameter("expiracion");
		Integer codigoCVC = Integer.valueOf(request.getParameter("codigoCVC"));
		
//		
//		if (usuActual != null) {
//		pagina = MODIFICADO_JSP;
//
//			Usuario UsuarioMod = usuActual;
//
//			UsuarioMod.setUsuario(usuario);
//
//			UsuarioMod.setClave(clave);
//
//			UsuarioMod.setNombre(nombre);
//
//			UsuarioMod.setApellidos(apellidos);
//
//			UsuarioMod.setEdad(edad);
//
//			UsuarioMod.setEmail(email);
//
//			UsuarioMod.setTelefono(telefono);
//
//			UsuarioMod.setDireccion(direccion);
//
//			UsuarioMod.setDescripcion(descripcion);
//
//			UsuarioMod.setIntereses(intereses);
//
//			dao.update(UsuarioMod);
//			
//			request.setAttribute("UsuarioModificar", UsuarioMod);
//
//		}else{
//Creo un usuario con los atributos
		
		Usuario us1 = new Usuario();
		us1.setUsuario(usuario);
		us1.setClave(clave);
		us1.setNombre(nombre);
		us1.setApellidos(apellidos);
		us1.setEdad(edad);
		us1.setRol(rol);
		us1.setEmail(email);
		us1.setTelefono(telefono);
		us1.setDireccion(direccion);
		us1.setDescripcion(descripcion);
		us1.setIntereses(intereses);
		us1.setNumeroTarjeta(numeroTarjeta);
		us1.setExpiracion(expiracion);
		us1.setCodigoCVC(codigoCVC);
		
		//listaUsuarios.add(us1);	
		try {
			dao.createUsuario(us1);
		}catch (Exception e){
			e.printStackTrace();
		}//añadir usuario a la lista de usuarios
		
		
		request.setAttribute("usuario", us1);		
		//request.setAttribute("listaUsuarios", listaUsuarios);
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", us1);
		
		//Pinta lo anterior en el jsp Perfil
		
		config2.getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
//	}
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