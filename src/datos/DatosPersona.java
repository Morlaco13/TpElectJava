package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entidades.Persona;

public class DatosPersona {
	
	public int buscarUsuario(String user, String pass){
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		int idUsuario = 0;

		sentenciaSQL = Conexion.nuevaInstancia().openConn().prepareStatement(
					"SELECT * FROM usuarios WHERE nombreUsuario = ? AND contrasena = ?");
			sentenciaSQL.setString(1, user);
			sentenciaSQL.setString(2, pass);
			resultado = sentenciaSQL.executeQuery();
			
			if (resultado != null && resultado.next()) {
				idUsuario = resultado.getInt("id");
		}

		// Este "Try-Catch" es para cerrar la conexión y sus resultados.

			if (resultado != null)
				resultado.close();
			if (sentenciaSQL != null)
				sentenciaSQL.close();
			Conexion.nuevaInstancia().closeConn();

		return idUsuario;
		}
	
	public Persona getBy
}
