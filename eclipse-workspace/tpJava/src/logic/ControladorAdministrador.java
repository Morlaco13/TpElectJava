package logic;

import datos.DatosAdministrador;
import entidades.Administrador;

public class ControladorAdministrador {

	DatosAdministrador datos = new DatosAdministrador();
	
	public Administrador buscar(Administrador a) {
		datos = new DatosAdministrador();
		return datos.buscar(a);
	}
}
