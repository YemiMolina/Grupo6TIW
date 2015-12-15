package es.uc3m.tiw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
	
	double importe;
	String numeroTarjeta;
	@Id
	String codigoPedido;
	@Temporal(TemporalType.DATE)
	Date FechaPedido;
	String codidoBanco;
	
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Date getFechaPedido() {
		return FechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		FechaPedido = fechaPedido;
	}
	public String getCodidoBanco() {
		return codidoBanco;
	}
	public void setCodidoBanco(String codidoBanco) {
		this.codidoBanco = codidoBanco;
	}
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
	
}
