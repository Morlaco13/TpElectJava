package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Marca;

public class DatosMarca {
	
	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private String anfitrion = "localhost";
	private String puerto = "3306";
	private String usuario = "root";
	private String contrasena = "47953";
	private String tipoBD = "mysql";
	private String bd = "tpjava";
	
	private Connection conn;
	
	public DatosMarca() {
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public LinkedList<Marca> listar(){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		try {
		LinkedList<Marca> marcas = new LinkedList<>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from marca");
		
		while(rs != null && rs.next()) {
			Marca m = new Marca();
			
			m.setIdMarca(rs.getInt("id"));
			m.setNombre(rs.getString("nombre"));
			
			marcas.add(m);
		}
		
		return marcas;
		
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
	
	public Marca buscar(Marca m) { //Recibo una persona que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //CAMBIAR POR THROW
		}
		
		try {
		Marca mar = null;
		stmt = conn.prepareStatement("select * from marca where id = ?");
		stmt.setInt(1, m.getIdMarca()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			mar = new Marca(); //Creo per aca porque sino encuentra debe devolver null
			mar.setIdMarca(rs.getInt("id"));
			mar.setNombre(rs.getString("nombre"));
			
			}
		
		return mar;
		
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
	
	public void alta(Marca m) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement(
					"insert into marca(nombre) values(?)", Statement.RETURN_GENERATED_KEYS);
			//roundtriptime ida y vuelta hasta la bd
			stmt.setString(1, m.getNombre());
		
			stmt.executeUpdate(); //devuelve la cantidad de filas actualizadas
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				m.setIdMarca(keyRS.getInt(1));
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
	
	public void baja(Marca m) {
		PreparedStatement stmt = null;
	  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("select * from marca where id = ?");
			
			stmt.setString(1, m.getNombre());
			
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
	
	public void update(Marca m) {
		PreparedStatement stmt = null;
		  
		try {
			conn =	DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd,usuario, contrasena);
			} catch (SQLException e) {
				e.printStackTrace(); //CAMBIAR POR THROW }
		}
		
		try {
			stmt = conn.prepareStatement("update marca set nombre = ?, where id = ?");
			
			stmt.setString(1, m.getNombre());
			stmt.setInt(2, m.getIdMarca());
		
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
