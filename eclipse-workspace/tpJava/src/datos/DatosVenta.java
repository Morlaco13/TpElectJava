package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.LineaVenta;
import entidades.Marca;
import entidades.Producto;
import entidades.Venta;

public class DatosVenta {

	public Venta buscar(Venta v) { // Recibo una Venta que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			Venta venta = null;
			
			stmt = Conexion.getInstancia().getConnection().prepareStatement("SELECT v.idVenta , v.fechaVenta "
					+ " , v.cli FROM venta v where id = ?");
			stmt.setInt(1, v.getIdVenta()); // Asigno al 1er ? el valor (no arranca en 0)
			rs = stmt.executeQuery();

			if (rs != null && rs.next()) { //Consulta rs.next() no deberia estar?
				venta.setIdVenta(rs.getInt("id"));
				venta.setFechaVenta(rs.getDate("fechaVenta"));
				//venta.setCli(rs.getCli("cli"));
								
			}

			return venta;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			  try {
				  if (rs != null) rs.close();
				  if (stmt != null)
					  stmt.close();
				  	  Conexion.getInstancia().releaseConnection();
			} catch (SQLException e){
				e.printStackTrace();
			}	 
		}
	}
}