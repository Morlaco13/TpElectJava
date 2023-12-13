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
import entidades.Producto;

public class DatosCategoria {
	
	public LinkedList<Categoria> listar(){
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
		LinkedList<Categoria> cats = new LinkedList<>();
		stmt = Conexion.getInstancia().getConnection().createStatement();
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
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Categoria buscar(Categoria c) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
				
		try {
		Categoria cat = null;
		stmt = Conexion.getInstancia().getConnection().prepareStatement("select * from categoria where idCategoria = ?");
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
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alta(Categoria c) {
		PreparedStatement stmt = null;
		ResultSet keyRS = null;
	  		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement(
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
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void baja(Categoria c) {
		PreparedStatement stmt = null;
	  		
		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement("DELETE from categoria where idCategoria = ?");
			
			stmt.setInt(1, c.getIdCategoria());
			
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
	
	public void update(Categoria c) {
		PreparedStatement stmt = null;

		try {
			stmt = Conexion.getInstancia().getConnection().prepareStatement("UPDATE categoria SET nombreCat = ? WHERE idCategoria = ?");
			
			stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getIdCategoria());
		
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

	public Categoria getById(Categoria c) {
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			Categoria cat = new Categoria();

			stmt = Conexion.getInstancia().getConnection().prepareStatement("select * from categoria c where c.idCategoria=?");

			stmt.setInt(1, c.getIdCategoria()); // Asigno al 1er ? el valor (no arranca en 0)
			rs = stmt.executeQuery();

			if (rs != null && rs.next()) { //Consulta rs.next() no deberia estar?
				cat = new Categoria(); // Creo aca porque sino encuentra debe devolver null
				cat.setIdCategoria(rs.getInt("idCategoria"));
				cat.setNombre(rs.getString("nombreCat"));
			}

			return cat;

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

	public Categoria buscarPorNombre(Categoria c) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
					
		try {
		Categoria cat = null;
		stmt = Conexion.getInstancia().getConnection().prepareStatement("SELECT * FROM categoria where nombreCat = ?");
		stmt.setString(1, c.getNombre()); // Asigno al 1er ? el valor (no arranca en 0)
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
				if (stmt != null) 
					stmt.close();
					Conexion.getInstancia().releaseConnection();
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	}
}
