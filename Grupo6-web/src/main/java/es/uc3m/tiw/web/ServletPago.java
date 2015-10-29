package es.uc3m.tiw.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPago
 */
@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPago() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=(String) request.getParameter("id");
		int idint= Integer.parseInt(id);
		Curso encontrado= ServletCursos.BuscarCurso(idint);
		Usuario usuActual=ServletRegistroUsuario.UsuarioActual(); //Busco en usuario actual
		ArrayList<Curso> UsuarioCursosLista= Usuario.getUsuarioCurso(); //obtengo su lista
		UsuarioCursosLista.add(encontrado);
		
		request.setAttribute("UsuarioCursosLista", UsuarioCursosLista);
		request.setAttribute("Curso", encontrado);
			this.getServletConfig().getServletContext().getRequestDispatcher("/Matriculacion.jsp").forward(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
