package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private String anfitrion = "localhost";
	private String puerto = "3306";
	private String usuario = "root";
	private String contrasena = "47953";
	private String tipoBD = "mysql";
	private String bd = "tpjava";

	private Connection conn;
	private static Conexion instanciaConn;

	private Conexion(){
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		
		}
	}
	
	public static Conexion crearInstancia(){
		if (instanciaConn == null) {
			instanciaConn = new Conexion();
		}
		return instanciaConn;
	}

	public Connection getConn(){
		try {
			if(conn != null && conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:mysql://"+anfitrion+":"+puerto+"/"+bd, usuario, contrasena);
			} 
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return conn;
	}

	public void releaseConn(){
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}