package centro_pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @name Conn.java
 * @purpose Connection
 * @author Group 4
 * @version 1.0
 */

public class Conn {

	private static String url = "jdbc:mysql://localhost:3306/ambulapokemon";
	private static String username = "root";
	private static String password = "";

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

		System.out.println("------------ MySQL JDBC Configuration------------");

		String nombre = "jdbc:mysql://localhost:";
		System.out.printf("\nPuerto: %n");
		nombre += sc.next() + "/";
		System.out.printf("\nNombre de base de datos: %n");
		nombre += sc.next();
		;
		System.out.printf("\nUsuario: %n");
		String usuario = sc.next();

		// En el caso de root no preguntamos por password
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
			Connection connection = DriverManager.getConnection(nombre, usuario, pass);

			setUrl(nombre);
			setUsername(usuario);
			setPassword(pass);

			System.out.println("------------ Datos actualizados! ------------");

			// Una vez comprobado que funciona, desconectamos

			if (sc != null)
				sc.close();

			if (connection != null)
				cierraConn(connection);

		} catch (SQLException e) {
			System.out.println("Error al configurar");
			// e.printStackTrace();
		}

	}

	public static Connection dameConn() {
		System.out.println("------------ MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al usar driver mysql");
			// e.printStackTrace();
		}

		System.out.println("MySQL JDBC Driver Registrado!");

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("------------ Conexion exitosa! ------------");
			return connection;

		} catch (SQLException e) {
			System.out.println("La conexion ha fallado, revise la configuracion de la base de datos");
			// e.printStackTrace();
		}

		return null;
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
