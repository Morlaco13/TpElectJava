package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Categoria;

public class DatosCategoria {
	
	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private String anfitrion = "localhost";
	private String puerto = "3306";
	private String usuario = "root";
	private String contrasena = "47953";
	private String tipoBD = "mysql";
	private String bd = "tpjava";
	
	private Connection conn;
	
	public DatosCategoria() {
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public LinkedList<Categoria> listar(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		try {
		LinkedList<Categoria> cats = new LinkedList<>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from categoria");
		
		while(rs != null && rs.next()) {
			Categoria c = new Categoria();
			
			c.setIdCategoria(rs.getInt("id"));
			c.setNombre(rs.getString("nombre"));
			
			cats.add(c);
		}
		
		return cats;
		
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
	
	public Categoria buscar(Categoria c) { //Recibo una persona que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		
		try {
		Categoria cat = null;
		stmt = conn.prepareStatement("select * from categoria where id = ?");
		stmt.setInt(1, c.getIdCategoria()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			cat = new Categoria(); //Creo per aca porque sino encuentra debe devolver null
			cat.setIdCategoria(rs.getInt("id"));
			cat.setNombre(rs.getString("nombre"));
			
			}
		
		return cat;
		
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
	
	public void alta(Categoria c) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement(
					"insert into categoria(nombre) values(?)", Statement.RETURN_GENERATED_KEYS);
			//roundtriptime ida y vuelta hasta la bd
			stmt.setString(1, c.getNombre());
		
			stmt.executeUpdate(); //devuelve la cantidad de filas actualizadas
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				c.setIdCategoria(keyRS.getInt(1));
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
	
	public void baja(Categoria c) {
		PreparedStatement stmt = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("select * from categoria where id = ?");
			
			stmt.setString(1, c.getNombre());
			
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
	
	public void update(Categoria c) {
		PreparedStatement stmt = null;
		  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("update categoria set nombre = ? where id = ?");
			
			stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getIdCategoria());
		
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