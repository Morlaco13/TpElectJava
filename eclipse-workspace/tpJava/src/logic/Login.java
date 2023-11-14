package logic;

import java.util.LinkedList;

public class Login {
	private DatosPersona dp;
	
	public Login() {
		dp = new DatosPersona();
	}
	
	public Persona validate(Persona p) {
		
		return dp.getByUser(p);
	}
	
	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}
	
	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);	
	}
}
