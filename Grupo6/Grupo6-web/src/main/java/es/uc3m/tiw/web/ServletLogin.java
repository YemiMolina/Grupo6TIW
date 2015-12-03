package es.uc3m.tiw.web;

import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.UsuarioDAO;

/**
 * Servlet implementation class BaseDatos
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//public static ArrayList <Usuario>  listaUsuarios;
	//public static ArrayList <Usuario>  listaCursos;
	
	
	
	/*public void init() throws ServletException {

		Usuario alumno1 = new Usuario("borjita", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "" );
		Usuario alumno2 = new Usuario("carlos", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		Usuario profesor1 = new Usuario("profe", "pass1", "Borja", "Perez", 21,2,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		Usuario admin = new Usuario("admin", "admin", "Administrador", "The boss", 21,0,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265, "");
		
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(alumno1);
		listaUsuarios.add(alumno2);
		listaUsuarios.add(profesor1);
		listaUsuarios.add(admin);
		}*/
		
		//private es.uc3m.tiw.model.Usuario usuario = new Usuario();;
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
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		try {
			listaUsuarios = dao.findAll();	
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String accion = request.getParameter("accion");
		switch (accion) {
		case "Index":
			config2.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Salir":
			session.invalidate();
			config2.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Perfil":
			if (session.getAttribute("usuario") != null) {
				request.setAttribute("usuario", session.getAttribute("usuario"));
				config2.getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
			}
			else{
				config2.getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			}
			
			break;
		case "Perfil2":
				request.getAttribute("usuario");
				config2.getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
				break;
				
		case "Perfiles":
			request.setAttribute("usuarios", listaUsuarios);
			config2.getServletContext().getRequestDispatcher("/MuestraUsuarios.jsp").forward(request, response);
			break;
		}
		
		/*this.getServletContext().getRequestDispatcher("/Index.jsp").forward(request,response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("user");
		String password = request.getParameter("pasw");
		String mensaje ;
		String pagina = "/Index.jsp";
		
		HttpSession session = request.getSession();
		/*ServletContext contexto = session.getServletContext();*/
		Usuario u = comprobarUsuario (user, password);
		if (u != null){
			try {
				
				listaUsuarios = dao.findAll();
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pagina = "/Perfil.jsp";
			request.setAttribute("usuarios", listaUsuarios);
			request.setAttribute("usuario", u);
			/*request.setAttribute("acceso", "ok");*/
			session.setAttribute("usuario", u);
			
		}else{
			mensaje = "Usuario o contraseña incorrectos";
			request.setAttribute("mensaje", mensaje);
		}
		config2.getServletContext().getRequestDispatcher(pagina).forward(request, response);
		
	}
	
	/*private Usuario comprobarUsuario(String user, String password){
		Usuario u = null;
		for(Usuario usuario: listaUsuarios){
			if(user.equals(usuario.getUsuario()) && password.equals(usuario.getClave())){
				u = usuario;
				break;
			}
		}
		return u;
	}*/
	
	private Usuario  comprobarUsuario(String user, String password) {
		Usuario usuario = dao.findByNickAndPassword(user,password);
		return usuario;
	}

}