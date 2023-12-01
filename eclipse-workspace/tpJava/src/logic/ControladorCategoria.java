package logic;

import java.util.LinkedList;
import datos.DatosCategoria;
import entidades.Categoria;

public class ControladorCategoria {

	DatosCategoria datos = new DatosCategoria();
	
	public LinkedList<Categoria> listar(){
		datos = new DatosCategoria();
		return datos.listar();
	}
	
	public Categoria buscar(Categoria c) {
		datos = new DatosCategoria();
		return datos.buscar(c);
	}
	
	public Categoria getById(Categoria c) {
		datos = new DatosCategoria();
		return datos.getById(c);
	}
	
	public void alta(Categoria c){
		datos.alta(c);
	}
	
	public void baja(Categoria c) {
		datos.baja(c);
	}

	public void update(Categoria c) {
		datos.update(c);
	}

	public Categoria buscarPorNombre(Categoria c) {
		datos = new DatosCategoria();
		return datos.buscarPorNombre(c);		
	}
}