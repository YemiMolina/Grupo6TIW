package es.uc3m.tiw.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BaseDatos
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList <Usuario>  listaUsuarios;
	public static ArrayList <Usuario>  listaCursos;
	
	
	
	public void init() throws ServletException {
		
		
		
		Usuario alumno1 = new Usuario("borjita", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		Usuario alumno2 = new Usuario("carlos", "pass1", "Borja", "Perez", 21,1,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		Usuario profesor1 = new Usuario("profe", "pass1", "Borja", "Perez", 21,2,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		Usuario admin = new Usuario("admin", "admin", "Administrador", "The boss", 21,2,"borjita@gmail.com","91888777555", "C/ Mediterraneo", "Chico", "Tecnologia", 87878, "17/15", 265);
		
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(alumno1);
		listaUsuarios.add(alumno2);
		listaUsuarios.add(profesor1);
		listaUsuarios.add(admin);
		
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
		String accion = request.getParameter("accion");
		switch (accion) {
		case "Index":
			this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Salir":
			session.invalidate();
			this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			break;
		case "Perfil":
			if (session.getAttribute("usuario") != null) {
				request.setAttribute("usuario", session.getAttribute("usuario"));
				this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
			}
			else{
				this.getServletConfig().getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
			}
			
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
			
			pagina = "/Perfil.jsp";
			request.setAttribute("usuarios", listaUsuarios);
			request.setAttribute("usuario", u);
			/*request.setAttribute("acceso", "ok");*/
			session.setAttribute("usuario", u);
			
		}else{
			mensaje = "Usuario o contraseña incorrectos";
			request.setAttribute("mensaje", mensaje);
		}
		this.getServletContext().getRequestDispatcher(pagina).forward(request, response);
		
	}
	
	private Usuario comprobarUsuario(String user, String password){
		Usuario u = null;
		for(Usuario usuario: listaUsuarios){
			if(user.equals(usuario.getUsuario()) && password.equals(usuario.getClave())){
				u = usuario;
				break;
			}
		}
		return u;
	}

}