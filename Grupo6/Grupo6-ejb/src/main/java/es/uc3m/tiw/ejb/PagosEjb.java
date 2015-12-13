package es.uc3m.tiw.ejb;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import es.uc3m.tiw.model.Pedido;

@Stateless(mappedName = "serviciosPago")
@LocalBean
public class PagosEjb implements PagoEjbLocal{
	
	public String pagar (Pedido pedido){
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/banco-web/resources/pasarela/pagoNormal/"+pedido.getImporte()+"/" +pedido.getCodigoTarjeta()+"/"+ generarCodigo()+"/" +"xml");
		/*Form form = new Form();
		form.param("importe", "" );
		form.param("numeroTarjeta", "" );
		form.param("codigoPedido", generarCodigo() );*/
		
		String bean =target.request(MediaType.TEXT_PLAIN).get(String.class);
		return bean;
	}
	
	public PagosEjb() {
		// TODO Auto-generated constructor stub
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
