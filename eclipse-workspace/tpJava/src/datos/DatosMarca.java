package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Categoria;
import entidades.Marca;

public class DatosMarca {
	
	public LinkedList<Marca> listar(){
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
		LinkedList<Marca> marcas = new LinkedList<>();
		stmt = Conexion.getInstancia().getConnection().createStatement();
		rs = stmt.executeQuery("select * from marca");
		
		while(rs != null && rs.next()) {
			Marca m = new Marca();
			
			m.setIdMarca(rs.getInt("idMarca"));
			m.setNombre(rs.getString("nombreMarca"));
			
			marcas.add(m);
		}
		
		return marcas;
		
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Marca buscar(Marca m) { //Recibo una persona que tenga solo el id
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
		Marca mar = null;
		stmt = Conexion.getInstancia().getConnection().prepareStatement("select * from marca where idMarca = ?");
		stmt.setInt(1, m.getIdMarca()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
		
		if (rs != null && rs.next()) {
			mar = new Marca(); //Creo per aca porque sino encuentra debe devolver null
			mar.setIdMarca(rs.getInt("idMarca"));
			mar.setNombre(rs.getString("nombreMarca"));
			
			}
		return mar;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null)
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alta(Marca m) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement(
					"insert into marca(nombreMarca) values(?)", Statement.RETURN_GENERATED_KEYS);
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
				if (stmt != null)
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void baja(Marca m) {
		PreparedStatement stmt = null;
	  		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement("DELETE from marca where idMarca = ?");
			
			stmt.setInt(1, m.getIdMarca());
			
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();				
		} finally {
			try {
				if (stmt != null)
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Marca m) {
		PreparedStatement stmt = null;
		  		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement("update marca set nombreMarca = ?, where idMarca = ?");
			
			stmt.setString(1, m.getNombre());
			stmt.setInt(2, m.getIdMarca());
		
			stmt.executeUpdate(); //mod a los datos
			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			try {
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Marca buscarPorNombre(Marca m) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
					
		try {
		Marca marca = new Marca();
		stmt = Conexion.getInstancia().getConnection().prepareStatement("SELECT * FROM marca where nombreMarca = ?");
		stmt.setString(1, m.getNombre()); // Asigno al 1er ? el valor (no arranca en 0)
		rs = stmt.executeQuery();
			
		if (rs != null && rs.next()) {
			marca.setIdMarca(rs.getInt("idMarca"));
			marca.setNombre(rs.getString("nombreMarca"));				
			}
			
		return marca;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	}
}
