package es.uc3m.tiw.web;

import java.io.IOException;
import java.util.ArrayList;

import es.uc3m.tiw.web.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ServletLecciones
 */
@WebServlet("/ServletLecciones")
@MultipartConfig
public class ServletLecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static int contadorId=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLecciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion=(String) request.getParameter("action");
        String id=(String) request.getParameter("id");
        String identificador=(String) request.getParameter("identificador");
        Integer idINT2=0;
        int idint= Integer.parseInt(id);
        Curso encontrado= ServletCursos.BuscarCurso(idint); //id del curso, asi enlazan las listas
        ArrayList<Leccion>    leecionlista=encontrado.getListaLecciones();
        if(identificador!=null){
            idINT2= Integer.valueOf(identificador);
            }
       
        if(accion!=null && accion.equals("delete")){
            leecionlista.remove(idINT2.intValue());   
        }
        request.setAttribute("Listalecciones", leecionlista);
            this.getServletConfig().getServletContext().getRequestDispatcher("/ListaLeccion.jsp").forward(request, response);
           
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCursoUrl= request.getParameter("id");
		int idCursoUrl1=Integer.parseInt(idCursoUrl);
		String descripcion =(String) request.getParameter("descripcion");
		//String material =(String) request.getParameter("material");
		
		Part filePart = request.getPart("material");
		String uri= ServletCursos.guardarImagen(filePart);
		//Curso curso= request.getParameter("curso"); //Pide string y es de tipo Curso
		
		//crea una nueva leccion con sus atributos 
		Leccion leccion= new Leccion() ;
		leccion.setIdentificador(contadorId);
		contadorId++;
		
		leccion.setDescripcion(descripcion);
		leccion.setMaterial(uri);
		//leccion.setMaterial(material);
		//leccion.setCurso(curso);
		
		//guardo el curso de la leccion
		Curso curso= ServletCursos.BuscarCurso(idCursoUrl1);
		//añado a la leccion el curso al que va dirigido
		leccion.setCurso(curso);
		
		ArrayList<Leccion> listaLecciones = curso.getListaLecciones();
		listaLecciones.add(leccion);
		
		//request.setAttribute("material", material);
		request.setAttribute("descripcion", descripcion);

		request.setAttribute("Listalecciones", listaLecciones);
		
		//pinta lo anterior en el jsp catalogo
		getServletContext().getRequestDispatcher("/CatalogoLecciones.jsp").forward(request, response);
		
		
		
	}
	
	
	}



