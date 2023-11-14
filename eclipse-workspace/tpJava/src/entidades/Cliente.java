package entidades;

import java.util.Date;
import java.util.LinkedList;

public class Cliente extends Persona{

	private Date fechaAlta;
	private Date fechaBaja;
	private LinkedList<Venta> compras;
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public LinkedList<Venta> getCompras() {
		return compras;
	}
	public void setCompras(LinkedList<Venta> compras) {
		this.compras = compras;
	}
	
	
}
