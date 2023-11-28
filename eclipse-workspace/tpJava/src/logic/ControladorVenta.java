package logic;

import datos.DatosVenta;
import entidades.Venta;

public class ControladorVenta {

	DatosVenta datos = new DatosVenta();
	
	public Venta alta(Venta v){
		datos = new DatosVenta();
		return datos.alta(v);
	}
}
