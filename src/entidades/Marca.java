package entidades;

public class Marca {

	private int idMarca;
	private String nombre;

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() { // NO SE USA, SOLO PARA PROBAR POR CONSOLA
		return "idMarca=" + idMarca + " nombre=" + nombre +"\n";
	}
}
