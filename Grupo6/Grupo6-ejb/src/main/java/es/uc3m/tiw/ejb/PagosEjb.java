package es.uc3m.tiw.ejb;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.daos.CursoDao;
import es.uc3m.tiw.model.daos.ICurso;
import es.uc3m.tiw.model.daos.IPedido;
import es.uc3m.tiw.model.daos.PedidoDao;

@Stateless(mappedName = "serviciosPago")
@LocalBean
public class PagosEjb implements PagoEjbLocal{
	
	@PersistenceContext( unitName="Grupo6-model")
	EntityManager em;
	private PedidoDao dao;
	
	public PagosEjb() {	
	}
	
	
	public String pagar (Pedido pedido){
		dao = new PedidoDao(em);
		
		String codigoPedido=generarCodigo();
		pedido.setCodigoPedido(codigoPedido);
		pedido.setFechaPedido(new Date());
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/banco-web/resources/pasarela/pagoNormal/"+pedido.getImporte()+"/" +pedido.getCodigoTarjeta()+"/"+pedido.getCodigoPedido() +"/"+"xml");
		String bean =target.request(MediaType.TEXT_PLAIN).get(String.class);
		pedido.setCodidoBanco(bean);
			try {
				dao.guardarPedido(pedido);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return bean;
	}
	
	
	
    public String generarCodigo(){
    	Date date = new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;		
		int day = cal.get(Calendar.DAY_OF_MONTH);		
		int hora =cal.get(Calendar.HOUR_OF_DAY);		
		int segundos = cal.get(Calendar.SECOND);	
		 int mili=cal.get(Calendar.MILLISECOND);
		 int am=cal.get(Calendar.AM_PM);
		String antes="";
		 if(am==0){
			 antes="am";
			 
		 }
		 if(am==1){
			 
			antes="pm"; 
		 }
		
		 String codigo="ORDER"+ String.valueOf(year)+ String.valueOf(month)+  String.valueOf(day)+ String.valueOf(hora)+ String.valueOf(segundos)+ String.valueOf(mili)+ antes ; 

    	
    	return codigo;
    	
    }
}
