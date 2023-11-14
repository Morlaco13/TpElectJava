package entidades;

import java.util.Date;

public class Venta {

	private int idVenta;
	private Date fechaVenta;
	private Cliente cli;
	private LineaVenta[] lineas;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public LineaVenta[] getLineas() {
		return lineas;
	}
	public void setLineas(LineaVenta[] lineas) {
		this.lineas = lineas;
	}
	
	
}
