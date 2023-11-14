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
	
	public LinkedList<Categoria> listar(){
		Statement stmt = null;
		ResultSet rs = null;
		
		Connection conn = Conexion.getConnection();
		
		try {
		LinkedList<Categoria> cats = new LinkedList<>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from categoria");
		
		while(rs != null && rs.next()) {
			Categoria c = new Categoria();
			
			c.setIdCategoria(rs.getInt("idCategoria"));
			c.setNombre(rs.getString("nombreCat"));
			
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
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Categoria buscar(Categoria c) { //Recibo una persona que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		Connection conn = Conexion.getConnection();
		
		try {
		Categoria cat = null;
		stmt = conn.prepareStatement("select * from categoria where idCategoria = ?");
		stmt.setInt(1, c.getIdCategoria()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			cat = new Categoria(); //Creo per aca porque sino encuentra debe devolver null
			cat.setIdCategoria(rs.getInt("idCategoria"));
			cat.setNombre(rs.getString("nombreCat"));
			
			}
		
		return cat;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alta(Categoria c) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  
		Connection conn = Conexion.getConnection();
		
		try {
			stmt = conn.prepareStatement(
					"insert into categoria(nombreCat) values(?)", Statement.RETURN_GENERATED_KEYS);
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
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void baja(Categoria c) {
		PreparedStatement stmt = null;
	  
		Connection conn = Conexion.getConnection();
		
		try {
			stmt = conn.prepareStatement("DELETE from categoria where idCategoria = ?");
			
			stmt.setString(1, c.getNombre());
			
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();				
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Categoria c) {
		PreparedStatement stmt = null;
		  
		Connection conn = Conexion.getConnection();
		
		try {
			stmt = conn.prepareStatement("update categoria set nombreCat = ? where idCategoria = ?");
			
			stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getIdCategoria());
		
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) Conexion.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}