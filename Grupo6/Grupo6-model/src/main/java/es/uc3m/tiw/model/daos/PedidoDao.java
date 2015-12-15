package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Pedido;

public class PedidoDao implements IPedido {


	private EntityManager em;
	private UserTransaction ut;
	
	
	public PedidoDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	

	public PedidoDao(EntityManager em2) {
		em = em2;
		// TODO Auto-generated constructor stub
	}

	//@Override
	public Pedido guardarPedido(Pedido pedido) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		
		//ut.begin();
		
		em.persist(pedido);
		//ut.commit();
		return pedido;
	}
	//@Override
	public Pedido buscarPedido(Long codigoPedido){
		return em.find(Pedido.class, codigoPedido);
	}
	@Override
	public void Pedido(Long id) {
		// TODO Auto-generated method stub
		
	}
}
