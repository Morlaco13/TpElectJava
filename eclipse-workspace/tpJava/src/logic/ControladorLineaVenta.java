package logic;

import datos.DatosLineaVenta;
import entidades.LineaVenta;

public class ControladorLineaVenta {
	
	DatosLineaVenta datos = new DatosLineaVenta();
	
	public void alta(LineaVenta lineaventa){
		datos.alta(lineaventa);
	}

	public void baja(LineaVenta lv) {
		datos.baja(lv);	
	}
}
