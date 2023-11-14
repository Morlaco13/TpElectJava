package entidades;

public class Categoria {

	private int idCategoria;
	private String nombreCat;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombreCat;
	}

	public void setNombre(String nombre) {
		this.nombreCat = nombre;
	}

	@Override
	public String toString() { // NO SE USA, SOLO PARA PROBAR POR CONSOLA
		return "nombreCat=" + nombreCat +"\n";
	}
}
