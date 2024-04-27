package centro_pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @name Conn.java
 * @purpose Connection
 * @author https://www.squash.io/how-to-connect-java-with-mysql/
 * @version 1.0
 */

public class Conn {

	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/ambulapokemon";
	private static String username = "root";
	private static String password = "";

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Conn.connection = connection;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Conn.url = url;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Conn.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Conn.password = password;
	}

	public static void configuraConn() {

		Scanner sc = new Scanner(System.in);
		
		String pass = "";

		System.out.println("-------- MySQL JDBC Configuration------------");

		String nombre = "jdbc:mysql://localhost:";
		System.out.printf("\nPuerto: %n");
		nombre += sc.next() + "/";
		System.out.printf("\nNombre de base de datos: %n");
		nombre += sc.next();
		;
		System.out.printf("\nUsuario: %n");
		String usuario = sc.next();
		if (!usuario.equals("root")) {
			System.out.printf("\nPass: %n");
			pass = sc.next();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar driver mySQL");
			// e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(nombre, usuario, pass);

			setUrl(nombre);
			setUsername(usuario);
			setPassword(pass);
			
			setConnection(connection);

			System.out.println("Datos actualizados");

		} catch (SQLException e) {
			System.out.println("Error al configurar");
			// e.printStackTrace();
		}

		if (connection != null)
			cierraConn(connection);

	}

	public static Connection dameConn() {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al usar driver mysql");
			// e.printStackTrace();
		}
		
		System.out.println("MySQL JDBC Driver Registrado!");

		try {
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			System.out.println("La connection ha fallado, revise la configuracion de la base de datos");
			// e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("Conexion exitosa");
		} else {
			System.out.println("Error");
		}
		return connection;
	}

	public static void cierraConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión");
			// e.printStackTrace();
		}
	}

}
