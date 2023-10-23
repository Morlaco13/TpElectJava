package entidades;

public class Marca {

	private int idMarca;
	private String nombreMarca;

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return nombreMarca;
	}

	public void setNombre(String nombre) {
		this.nombreMarca = nombre;
	}
	@Override
	public String toString() { // NO SE USA, SOLO PARA PROBAR POR CONSOLA
		return "nombreMarca=" + nombreMarca +"\n";
	}
}
