package es.uc3m.tiw.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Curso;
import es.uc3m.tiw.model.Vale;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.IUsuario;
import es.uc3m.tiw.model.daos.IValeDescuento;
import es.uc3m.tiw.model.daos.UsuarioDAO;
import es.uc3m.tiw.model.daos.ValeDescuentoDao;

/**
 * Servlet implementation class ServletPromociones
 */
@WebServlet("/ServletValesDescuento")
public class ServletValesDescuento extends HttpServlet {
    private static final long serialVersionUID = 1L;
	public static List <Vale> ListaVales = new ArrayList<Vale>();  
	public static int contador=0;
	@PersistenceContext( unitName="Grupo6-model")
	EntityManager em;
	@Resource
	UserTransaction ut;
	IValeDescuento daov;
	IUsuario daou;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValesDescuento() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	daov = new ValeDescuentoDao(em, ut);
    	daou = new UsuarioDAO(em, ut);
    	
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
        Usuario usuActual= (Usuario)session.getAttribute("usuario");
        request.setAttribute("usuario", usuActual);
    	request.setAttribute("ListaVales", ListaVales);
    	this.getServletConfig().getServletContext().getRequestDispatcher("/ValesDescuento.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Usuario usuActual= (Usuario)session.getAttribute("usuario");
    	String nombre =request.getParameter("nombre");
        long cantidad=Long.parseLong(request.getParameter("cantidad"));
        Integer numeroCursosinscrito=Integer.parseInt(request.getParameter("numeroCursosinscrito"));
        double numeroMinMatricula= Double.parseDouble(request.getParameter("numeroMinMatricula"));
        String FechaCaducidadSrt= request.getParameter("fechaCaducidad");
        Date FechaCaducidad=null;
 	try {
 		FechaCaducidad = new SimpleDateFormat("dd/MM/yyyy").parse(FechaCaducidadSrt);
 	} catch (ParseException e1) {
 		// TODO Auto-generated catch block
 		e1.printStackTrace();
 	}
        
       Integer idProfesor = usuActual.getIdusuarios();//seria el usuario actual
        
       Usuario profesor= BuscarProfesor(idProfesor);
        
        Vale vale= new Vale();
         
        	
        	
         vale.setNombre(nombre);
         vale.setFechaCaducidad(FechaCaducidad);
         vale.setCantidad(cantidad);
         vale.setProfesor(profesor);
         
         vale.setNumeroCursosinscrito(numeroCursosinscrito);
         vale.setNumeroMinMatricula(numeroMinMatricula);
         String codigoFinal=generacodigo(vale);
         vale.setCodigo(codigoFinal);
         
         contador++;
         
         try {
 			daov.createVale(vale);
 		} catch (InstantiationException | IllegalAccessException
 				| ClassNotFoundException | IllegalStateException
 				| SecurityException | SQLException | NotSupportedException
 				| SystemException | HeuristicMixedException
 				| HeuristicRollbackException | RollbackException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
         List<Vale>ListaVales= daov.BuscarValesProfesor(idProfesor);
         
         request.setAttribute("ListaVales", ListaVales);
         request.setAttribute("usuario", profesor);
        // request.setAttribute("profesor", idProfesor);
         this.getServletConfig().getServletContext().getRequestDispatcher("/ValesDescuento.jsp").forward(request, response);
     
         
         
     }

     public Usuario BuscarProfesor(int id){
     	return daou.findById(id);
     	
     	
     }
     public String generacodigo(Vale vale){
     	Calendar calendar= Calendar.getInstance();
     	Integer año= calendar.get(Calendar.YEAR);
     	Integer mes=calendar.get(Calendar.MONTH);
     	Integer dia=calendar.get(Calendar.DAY_OF_MONTH);
     	Integer hora=calendar.get(Calendar.HOUR);
     	Integer segundo= calendar.get(Calendar.SECOND);
     	Integer milisegundos=calendar.get(Calendar.MILLISECOND);
     	Integer ampm=calendar.get(Calendar.AM_PM);
     	String AMPM=null;
     	
     	if(ampm==Calendar.AM){
     		 AMPM="AM";
     	}else{
     		 AMPM="PM";
     	}
     	String CodigoFinal= "Vale"+año+mes+dia+hora+segundo+milisegundos+AMPM+vale.getCantidad();
     	
     	return CodigoFinal;
     
     }
     
    
     
     
 }