package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Producto;

public class DatosProductos {
	
	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private String anfitrion = "localhost";
	private String puerto = "3306";
	private String usuario = "root";
	private String contrasena = "47953";
	private String tipoBD = "mysql";
	private String bd = "tpjava";
	
	private Connection conn = null;
	
	public DatosProductos() {
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	public LinkedList<Producto> listar(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		try {
		LinkedList<Producto> prods = new LinkedList<>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from producto");
		
		while(rs != null && rs.next()) {
			Producto p = new Producto();
			
			p.setIdProducto(rs.getInt("id"));
			p.setDescripcion(rs.getString("descripcion"));
			p.setNombre(rs.getString("nombre"));
			p.setPrecio(rs.getInt("precio"));
			p.setStock(rs.getInt("stock"));
			
			prods.add(p);
		}
		
		return prods;
		
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Producto buscar(Producto p) { //Recibo un producto que tenga solo el id	
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		
		try {
		Producto prod = null;
		stmt = conn.prepareStatement("select * from producto where id = ?");
		stmt.setInt(1, p.getIdProducto()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			prod = new Producto(); //Creo aca porque sino encuentra debe devolver null
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
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alta(Producto p) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement(
					"insert into producto(nombre, descripcion, precio, stock) "
					+ "values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			// Si el orden es diferente en la bd, no importa 
			//roundtriptime ida y vuelta hasta la bd
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getDescripcion());
			stmt.setInt(3, p.getPrecio());
			stmt.setInt(4, p.getStock());
		
			stmt.executeUpdate(); //devuelve la cantidad de filas actualizadas
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				p.setIdProducto(keyRS.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();				
		} finally {
			try {
				if (keyRS != null) keyRS.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void baja(Producto p) {
		PreparedStatement stmt = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("select * from producto where id = ?");
			
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getDescripcion());
			stmt.setInt(4, p.getPrecio());
			stmt.setInt(5, p.getStock());
		
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();				
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void update(Producto p) {
		PreparedStatement stmt = null;
		  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("update producto set nombre = ?, descripcion = ?"
					+ ", precio = ?, stock = ? where id = ?");
			
			stmt.setString(1, p.getNombre());
			stmt.setString(2,  p.getDescripcion());
			stmt.setInt(3, p.getPrecio());
			stmt.setInt(4, p.getStock());
			stmt.setInt(5, p.getIdProducto());
		
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();				
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
