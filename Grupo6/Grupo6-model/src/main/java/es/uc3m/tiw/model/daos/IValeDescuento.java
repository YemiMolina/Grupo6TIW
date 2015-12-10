package es.uc3m.tiw.model.daos;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.model.Leccion;
import es.uc3m.tiw.model.Vale;

public  interface IValeDescuento {
	
	public abstract Vale createVale(Vale ValeNuevo)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, NotSupportedException, SystemException, IllegalStateException, SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException;

	public abstract List<Vale> findAll() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException;

	public abstract Vale findById(int id) throws SQLException;

	public abstract void removeLeccion(Vale vale)
			throws NotSupportedException, SystemException,
			IllegalStateException, SecurityException, HeuristicMixedException,
			HeuristicRollbackException, RollbackException;

	public abstract List<Vale> BuscarValesProfesor(int id);

}
