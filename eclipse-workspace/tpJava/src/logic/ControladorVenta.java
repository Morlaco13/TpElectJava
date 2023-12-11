package logic;

import java.util.ArrayList;

import datos.DatosVenta;
import entidades.Venta;

public class ControladorVenta {

	DatosVenta datos = new DatosVenta();
	
	public Venta alta(Venta v){
		datos = new DatosVenta();
		return datos.alta(v);
	}

	public ArrayList<Venta> getHistIdPersona(int id) {
		datos = new DatosVenta();
		return datos.getHistIdPersona(id);
	}
}
