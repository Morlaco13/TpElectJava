package logic;

import datos.DatosVenta;
import entidades.Venta;

public class ControladorVenta {

	DatosVenta datos = new DatosVenta();
	
	public void alta(Venta v){
		datos.alta(v);
	}
}
