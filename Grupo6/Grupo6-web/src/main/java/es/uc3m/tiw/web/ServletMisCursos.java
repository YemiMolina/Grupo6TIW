package es.uc3m.tiw.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.ejb.PagoEjbLocal;
import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.Vale;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.ILeccion;
import es.uc3m.tiw.model.daos.IUsuario;
import es.uc3m.tiw.model.daos.IValeDescuento;
import es.uc3m.tiw.model.daos.LeccionDao;
import es.uc3m.tiw.model.daos.UsuarioDAO;
import es.uc3m.tiw.model.daos.ValeDescuentoDao;

/**
 * Servlet implementation class MisCursos
 */
@WebServlet("/ServletMisCursos")
public class ServletMisCursos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	@PersistenceContext(unitName = "Grupo6-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	ILeccion dao;
	ICurso daoc;
	IUsuario daou;
	IValeDescuento daov;
	@EJB
	PagoEjbLocal interfaz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMisCursos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new LeccionDao(em, ut);
		daoc = new CursoDao(em, ut);
		daou = new UsuarioDAO(em, ut);
		daov = new ValeDescuentoDao(em, ut);
	}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Usuario usuActual= (Usuario)session.getAttribute("usuario");
    	String action=request.getParameter("action");
    	
    	if(action!=null && action.equals("VerMatriculados")){
    	
    	Usuario usuActual1= BuscarUsuario(usuActual.getIdusuarios());
        List<Curso> CursosMatriculados = new ArrayList<Curso>();
        CursosMatriculados= usuActual1.getListaCursosAlumno();
        daou.update(usuActual1);
        request.setAttribute("CursosMatriculados", CursosMatriculados);     
        request.setAttribute("usuario", usuActual1);
        this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
    	
    	}else if (action!=null && action.equals("VerDeseos")){
    		
        	Usuario usuActual1= BuscarUsuario(usuActual.getIdusuarios());
            List<Curso> CursosDeseo = new ArrayList<Curso>();
            CursosDeseo= usuActual1.getListaDeseos();
            daou.update(usuActual1);
            request.setAttribute("CursosDeseo", CursosDeseo);     
            request.setAttribute("usuario", usuActual1);
            this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
        	
    		
    	}else if(action!=null && action.equals("AniadirDeseo")){
    		
    		String id=(String) request.getParameter("id");
            int idint= Integer.parseInt(id);
            //busca el curso con el id
            Curso encontrado= BuscarCurso(idint);
  
            //Busco en usuario actual
            /*//iniar la sesion y meto el objeto que quiera
            request.getSession().setAttribute("usuarioActual", usuActual);
            //Aqui meto la info del obj usuario y ya puedo acceder a el y obtener lo que quiera
            Usuario usuActual2= (Usuario) request.getSession().getAttribute("usuarioActual");*/
           
            Usuario usuActual1= BuscarUsuario(usuActual.getIdusuarios());
            List<Curso> CursosDeseo = new ArrayList<Curso>();
           
           // CursosMatriculados=usuActual.getUsuarioCurso();
           // encontrado.matricular(usuActual);
           //CursosMatriculados= Usuario.Matricular(encontrado);
            
            CursosDeseo= usuActual1.getListaDeseos();
           if( usuActual1.EstaMatriculado(encontrado.getIdcursos())){
        	   this.getServletConfig().getServletContext().getRequestDispatcher("/Mensaje.jsp").forward(request, response);      
           }else{
            
        	CursosDeseo.add(encontrado);
            daou.update(usuActual1);
            request.setAttribute("CursosDeseo", CursosDeseo);
            request.setAttribute("Curso", encontrado);
            request.setAttribute("usuario", usuActual1);
 
            this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
           }	
    		
    	}	
        
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

    }
	public Curso BuscarCurso(int id) {
		// int IdCurso2=0;
		Curso CursoEncotrado = null;
		try {
			CursoEncotrado = daoc.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CursoEncotrado;
	}

	public Usuario BuscarUsuario(int id) {
		// int IdCurso2=0;
		Usuario UsuarioEncontrado = null;
		try {
			UsuarioEncontrado = daou.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsuarioEncontrado;
	}
}