package datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.LineaVenta;
import entidades.Marca;
import entidades.Producto;
import entidades.Venta;
import logic.ControladorPersona;

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
				//venta.setPer(rs.getInt("cli"));
								
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
	
	public Venta alta(Venta v) {		
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement(
					"insert into venta(fechaVenta, cli) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			//FALTA DATOS DE LA VENTA, INCLUIDO EL CLIENTE QUE DEBERIA APARECER EN LA SESSION
			stmt.setDate(1, (Date) v.getFechaVenta());
			stmt.setInt(2, v.getPer().getIdPersona());

			stmt.executeUpdate(); // devuelve la cantidad de filas actualizadas
			keyRS = stmt.getGeneratedKeys();

			if (keyRS != null && keyRS.next()) {
				v.setIdVenta(keyRS.getInt(1));
				
				ArrayList<LineaVenta> lineaVenta = (ArrayList<LineaVenta>) v.getLineas();
				for (LineaVenta lv : lineaVenta) { //AGREGO IDVENTA A LAS LINEASVENTAS
					lv.setIdVenta(v.getIdVenta());
				}
				v.setLineas(lineaVenta);
			}

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
		return v; //TUVIMOS QUE PONERLO ACA PORQUE NO FUNCIONABA SINO Y NO PUDIMOS SOLUCIONARLO
	}
}
