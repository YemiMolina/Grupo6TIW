package es.uc3m.tiw.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Mensaje;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.IUsuario;
import es.uc3m.tiw.model.daos.MensajesDao;
import es.uc3m.tiw.model.daos.UsuarioDAO;
import es.uc3m.tiw.web.jms.EscribirEnQueue;

/**
 * Servlet implementation class MensajesServlet
 */
@WebServlet("/mensajes")
public class MensajesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName="Grupo6-model")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
    private IUsuario dao;
    private MensajesDao msgDao;
    @Inject
    private EscribirEnQueue colaMensajes;
    private List<Usuario> listaUsuarios;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init() throws ServletException {
        dao = new UsuarioDAO (em, ut);
        msgDao = new MensajesDao(em, ut);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        List<Mensaje> mensajes = msgDao.findAllMessagesByUsuario(u);
        request.setAttribute("listaMensajes", mensajes);
        this.getServletContext().getRequestDispatcher("/listaMensajes.jsp").forward(request, response);
        
        
        
        
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String mensaje = request.getParameter("mensaje");
        Usuario from = dao.findById(Integer.valueOf(request.getParameter("from")));
        Usuario to = dao.findById(Integer.valueOf(request.getParameter("to")));
        Mensaje msg = new Mensaje(mensaje,from, to);
        

        colaMensajes.enviar(msg);
        
        try {
            
            listaUsuarios = dao.findAll();
            
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("usuarios", listaUsuarios);
        
        HttpSession session = request.getSession();
        request.setAttribute("usuario", session.getAttribute("usuario"));
        this.getServletConfig().getServletContext().getRequestDispatcher("/Perfil.jsp").forward(request, response);
        
        
        
    
    }

} 