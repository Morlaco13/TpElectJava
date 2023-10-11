package logic;

import java.util.LinkedList;
import datos.DatosMarca;
import entidades.Marca;

public class ControladorMarca {

	DatosMarca datos = new DatosMarca();
	
	public LinkedList<Marca> listar(){
		datos = new DatosMarca();
		return datos.listar();
	}
	
	public Marca buscar(Marca m) {
		datos = new DatosMarca();
		return datos.buscar(m);
	}
	
	public void alta(Marca m){
		datos.alta(m);
	}
	
	public void baja(Marca m) {
		datos.baja(m);
	}

	public void update(Marca m) {
		datos.update(m);
	}
}