package entidades;

public class Categoria {

	private int idCategoria;
	private String nombre;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() { // NO SE USA, SOLO PARA PROBAR POR CONSOLA
		return "idCategoria=" + idCategoria + " nombre=" + nombre +"\n";
	}
}
