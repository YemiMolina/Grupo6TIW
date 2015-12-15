package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.Pedido;

public  interface IPedido {
	
	public abstract Pedido guardarPedido(Pedido pedido)throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;
	
	public abstract void Pedido (Long id)throws SQLException;
	
}
