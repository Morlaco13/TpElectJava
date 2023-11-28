package entidades;

public class LineaVenta {

	private Producto prod;
	private int cant;
	private int precioUnit;
	private int idVenta;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public Producto getProd() {
		return prod;
	}
	public void setProd(Producto prod) {
		this.prod = prod;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public int getPrecioUnit() {
		return precioUnit;
	}
	public void setPrecioUnit(int precioUnit) {
		this.precioUnit = precioUnit;
	}
	
	
}
