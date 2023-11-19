package logic;

import java.util.LinkedList;

import datos.DatosPersona;
import entidades.Persona;

public class Login {
	private DatosPersona dp;
	
	public Login() {
		dp = new DatosPersona();
	}
	
	public Persona validate(Persona p) {
		
		return dp.getByUser(p);
	}
	
	public LinkedList<Persona> getAll(){
		return dp.listar();
	}
	
	public Persona getByDocumento(Persona per) {
		return dp.getByDni(per);	
	}
}
