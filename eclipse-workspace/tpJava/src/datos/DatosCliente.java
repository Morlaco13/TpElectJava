package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cliente;

public class DatosCliente {

	public Cliente buscar(Cliente c) { //Recibo un Cliente que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
		Cliente cli = null;
		stmt = Conexion.getInstancia().getConnection().prepareStatement("select * from persona where id = ?");
		stmt.setInt(1, c.getIdPersona()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			cli = new Cliente();
			cli.setIdPersona(rs.getInt("id"));
			cli.setNombre(rs.getString("nombre"));
			cli.setApellido(rs.getString("apellido"));
			cli.setDni(rs.getInt("dni"));
			cli.setTelefono(rs.getInt("telefono"));
			cli.setDireccion(rs.getString("direccion"));
			cli.setEmail(rs.getString("email"));
			cli.setEsAdmin(rs.getBoolean("esAdmin"));
			
			}
		return cli;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
