package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.LineaVenta;
import entidades.Producto;
import entidades.Venta;

public class DatosLineaVenta {
	
	public void alta(LineaVenta lineaVenta) {		
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement(
					"insert into lineaventa(idVenta, idProducto, cantidad, precioUnitario) values(?,?,?,?)");
					//,Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, lineaVenta.getIdVenta());
			stmt.setInt(2, lineaVenta.getProd().getIdProducto());
			stmt.setInt(3, lineaVenta.getCant());
			stmt.setInt(4, lineaVenta.getPrecioUnit());

			stmt.executeUpdate(); // devuelve la cantidad de filas actualizadas
			//keyRS = stmt.getGeneratedKeys();

			//if (keyRS != null && keyRS.next()) {
			//	lineaVenta.setIdVenta(keyRS.getInt(1));
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{try {
				if (keyRS != null) keyRS.close();
				if (stmt != null)
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }	 
		}
	}

	public void baja(LineaVenta lv) {
		PreparedStatement stmt = null;

		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement("DELETE from lineaventa where idproducto = ? AND idventa = ?");

			stmt.setInt(1, lv.getProd().getIdProducto());
			stmt.setInt(2, lv.getIdVenta());

			stmt.executeUpdate(); // mod a los datos

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				if (stmt != null)
					stmt.close();
				Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) { e.printStackTrace();
			}	 
		}
	}
}

