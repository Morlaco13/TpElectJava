package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private static String anfitrion = "localhost";
	private static String puerto = "3306";
	private static String usuario = "root";
	private static String contrasena = "47953";
	private static String tipoBD = "mysql";
	private static String bd = "tpjava";

	private static Connection conn;

	private Conexion(){
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		
		}
	}

	@SuppressWarnings("finally")
	public static Connection getConnection() {
	    try {
	        if (conn == null || conn.isClosed()) {
	            conn = DriverManager.getConnection("jdbc:mysql://" + anfitrion + ":" + puerto + "/" + bd, usuario, contrasena);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        return conn;
	    }
	}

	public static void releaseConnection(){
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}