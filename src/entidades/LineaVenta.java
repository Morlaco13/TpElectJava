package entidades;

public class LineaVenta {

	private Producto prod;
	private int cant;
	private int precioUnit;
	
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
