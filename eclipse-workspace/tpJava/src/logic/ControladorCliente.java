package logic;

import datos.DatosCliente;
import entidades.Cliente;

public class ControladorCliente {

	DatosCliente datos = new DatosCliente();
	
	public Cliente buscar(Cliente c) {
		datos = new DatosCliente();
		return datos.buscar(c);
	}
}
