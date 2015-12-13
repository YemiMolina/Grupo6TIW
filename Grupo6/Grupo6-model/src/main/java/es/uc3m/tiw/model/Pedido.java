package es.uc3m.tiw.model;

import java.io.Serializable;

public class Pedido implements Serializable {

	double importe;
	String numeroTarjeta;
	String codigoPedido;
	
	
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getCodigoTarjeta() {
		return numeroTarjeta;
	}
	public void setCodigoTarjeta(String codigoTarjeta) {
		this.numeroTarjeta = codigoTarjeta;
	}
	public String getCodigopedido() {
		return codigoPedido;
	}
	public void setCodigopedido(String codigopedido) {
		this.codigoPedido = codigopedido;
	}
}
