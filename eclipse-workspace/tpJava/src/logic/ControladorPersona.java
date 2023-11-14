package logic;

import java.util.LinkedList;
import datos.DatosPersona;
import entidades.Persona;

public class ControladorPersona {

	DatosPersona datos = new DatosPersona();
	
	public Persona getByUser(Persona p) {
		datos = new DatosPersona();
		return datos.getByUser(p);
	}
	
	public Persona getByDni(Persona p) {
		datos = new DatosPersona();
		return datos.getByDni(p);
	}
	
	public LinkedList<Persona> listar(){
		datos = new DatosPersona();
		return datos.listar();
	}
	
	public Persona buscar(Persona p) {
		datos = new DatosPersona();
		return datos.buscar(p);
	}
	
	public void alta(Persona p){
		datos.alta(p);
	}
	
	public void baja(Persona p) {
		datos.baja(p);
	}

	public void update(Persona p) {
		datos.update(p);
	}
}
