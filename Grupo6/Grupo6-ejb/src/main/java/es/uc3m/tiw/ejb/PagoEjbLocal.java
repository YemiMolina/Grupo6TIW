package es.uc3m.tiw.ejb;

import javax.ejb.Local;

import es.uc3m.tiw.model.Pedido;
@Local
public interface  PagoEjbLocal {
	
	public abstract String pagar(Pedido pedido);
	
}
