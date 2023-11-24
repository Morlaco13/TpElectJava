package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

	private int idVenta;
	private Date fechaVenta;
	//private Cliente cli;
	private Persona per;
	List<LineaVenta> lineas = new ArrayList<>();
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setLineas(List<LineaVenta> lineas) {
		this.lineas = lineas;
	}
	
	public List<LineaVenta> getLineas(){
		return this.lineas;
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
	//public Cliente getCli() {
	//	return cli;
	//}
	//public void setCli(Cliente cli) {
	//	this.cli = cli;
	//}
	
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
	
	public void addLinea(LineaVenta linea) {
		this.lineas.add(linea);
	}
	
}
