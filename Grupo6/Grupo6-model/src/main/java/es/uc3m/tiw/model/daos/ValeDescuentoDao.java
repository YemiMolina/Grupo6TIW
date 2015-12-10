package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Vale;

public class ValeDescuentoDao implements IValeDescuento {
	
	private EntityManager em;
	private UserTransaction ut;
	
	
	public ValeDescuentoDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	@Override
	public Vale createVale(Vale valeNuevo) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException {

		ut.begin();
		em.persist(valeNuevo);
		ut.commit();
		return valeNuevo;
		
	}
	/* (non-Javadoc)
	 * @see es.uc3m.tiw.model.daos.IPersona#findAll()
	 */
	@Override
	public List<Vale> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		List<Vale> listaVales = em.createQuery("SELECT v from Vale v",Vale.class).getResultList();
		
		return listaVales;
	}
	
	@Override
	public Vale findById(int id) {
	return 	em.find(Vale.class, new Integer(id));

	}
	
	public List<Vale> BuscarValesProfesor(int id){
	
		List<Vale> listaValesProfesor = em.createQuery("SELECT v from Vale v join fetch v.profesor WHERE v.profesor.idusuarios = :idusuarios",Vale.class).setParameter("idusuarios", id).getResultList();
				return listaValesProfesor;
		
	}
	
	
	@Override
	public void removeLeccion(Vale vale) throws NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException{
		ut.begin();
		em.remove(em.merge(vale));
		ut.commit();
	}
	
	public Vale findByIdAndName(int idVale, String titulo) {// este igual hay q cambiarlo y encontrarlo por id solamente y con alguna relacion con el curso. 
		
		Query query =  em.createQuery("SELECT u FROM Vale u where u.idvale=:idleccion and u.titulo=:titulo", Vale.class);
		query.setParameter("idcursos", idVale);
		query.setParameter("titulo", titulo);
		return (Vale) query.getSingleResult();
		
		
	}

}
