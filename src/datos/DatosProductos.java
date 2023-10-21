package datos;

import java.sql.Connection;
import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Marca;
import entidades.Producto;

public class DatosProductos {

	public LinkedList<Producto> listar() {
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = Conexion.getConnection();

		try {
			LinkedList<Producto> prods = new LinkedList<>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from producto");

			while (rs != null && rs.next()) {
				Producto p = new Producto();

				p.setIdProducto(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getInt("precio"));
				p.setStock(rs.getInt("stock"));

				prods.add(p);
			}

			return prods;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Producto buscar(Producto p) { // Recibo un producto que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;

		Connection conn = Conexion.getConnection();

		try {
			Producto prod = null;
			stmt = conn.prepareStatement("select * from producto where id = ?");
			stmt.setInt(1, p.getIdProducto()); // Asigno al 1er ? el valor (no arranca en 0)
			rs = stmt.executeQuery();

			if (rs != null && rs.next()) {
				prod = new Producto(); // Creo aca porque sino encuentra debe devolver null
				prod.setIdProducto(rs.getInt("id"));
				prod.setDescripcion(rs.getString("descripcion"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setStock(rs.getInt("stock"));

			}

			return prod;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			  try {
				  if (rs != null) rs.close();
				  if (stmt != null) stmt.close();
				  if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e){
				e.printStackTrace();
			}	 
		}
	}

	public void alta(Producto p) {
		
		PreparedStatement stmt = null;
		ResultSet keyRS = null;

		Connection conn = Conexion.getConnection();
		
		try {
			stmt = conn.prepareStatement(
					"insert into producto(nombre, descripcion, precio, stock) " + "values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			// Si el orden es diferente en la bd, no importa
			// roundtriptime ida y vuelta hasta la bd
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getDescripcion());
			stmt.setInt(3, p.getPrecio());
			stmt.setInt(4, p.getStock());

			stmt.executeUpdate(); // devuelve la cantidad de filas actualizadas
			keyRS = stmt.getGeneratedKeys();

			if (keyRS != null && keyRS.next()) {
				p.setIdProducto(keyRS.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{try {
				if (keyRS != null) keyRS.close();
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }	 
		}
	}

	public void baja(Producto p) {
		PreparedStatement stmt = null;

		Connection conn = Conexion.getConnection();

		try {
			stmt = conn.prepareStatement("DELETE from producto where id = ?");

			stmt.setInt(1, p.getIdProducto());

			stmt.executeUpdate(); // mod a los datos

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();		 
			 } catch (SQLException e) { e.printStackTrace();
			 }	 
		}
	}

	public void update(Producto p) {
		PreparedStatement stmt = null;

		Connection conn = Conexion.getConnection();

		try {
			stmt = conn.prepareStatement(
					"update producto set nombre = ?, descripcion = ?" + ", precio = ?, stock = ? where id = ?");

			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getDescripcion());
			stmt.setInt(3, p.getPrecio());
			stmt.setInt(4, p.getStock());
			stmt.setInt(5, p.getIdProducto());

			stmt.executeUpdate(); // mod a los datos

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();			 
			 } catch (SQLException e) { e.printStackTrace();
			 }	 
		}
	}
	
	public LinkedList<Producto> listadoPorPrecioA() {
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = Conexion.getConnection();
		
		try {
			LinkedList<Producto> prods = new LinkedList<>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM producto ORDER BY precio ASC");
			//INCLUYO ASC EN LA CONSULTA PARA QUE SE ENTIENDA MEJOR ( VALOR DEFAULT )
			while (rs != null && rs.next()) {
				Producto p = new Producto();

				p.setIdProducto(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getInt("precio"));
				p.setStock(rs.getInt("stock"));

				prods.add(p);
			}

			return prods;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		  try {
			  if (rs != null) rs.close();
			  if (stmt != null) stmt.close();
			  if (conn != null) Conexion.releaseConnection();
		} catch (SQLException e){
			e.printStackTrace();
		}	 
	}
}
	public LinkedList<Producto> listadoPorPrecioD() {
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = Conexion.getConnection();
		
		try {
			LinkedList<Producto> prods = new LinkedList<>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM producto ORDER BY precio DESC");
			
			while (rs != null && rs.next()) {
				Producto p = new Producto();

				p.setIdProducto(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getInt("precio"));
				p.setStock(rs.getInt("stock"));

				prods.add(p);
			}

			return prods;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally {
		  try {
			  if (rs != null) rs.close();
			  if (stmt != null) stmt.close();
			  if (conn != null) Conexion.releaseConnection();
		} catch (SQLException e){
			e.printStackTrace();
		}	 
	}
}

}
