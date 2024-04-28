package centro_pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @name Crud.java
 * @purpose BD
 * @author Group 4
 * @version 1.0
 */

public class Crud {

	private static Connection conn = null;
	Scanner sc;

	public Crud() {
		Crud.conn = Conn.dameConn();
		sc = new Scanner(System.in);
		// if (sc != null) sc.close();
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		Crud.conn = conn;
	}

	public void Insert(String t) {
		if (t.equals("centro")) {
			try {

				// Prepare the SQL statement
				String insertQuery = "INSERT INTO " + t
						+ " (nombre, localidad, presupuesto, trabajador) VALUES (?, ?, ?, ?)";
				PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
				// Set parameter values
				preparedStatement.setString(1, "TORRE DE LOS GUZMANES");
				preparedStatement.setString(2, "La algaba");
				preparedStatement.setDouble(3, 6000);
				preparedStatement.setInt(4, 1);
				// Execute the prepared statement
				int rowsInserted = preparedStatement.executeUpdate();
				System.out.println(rowsInserted + " row(s) inserted.");

			} catch (SQLException e) {
				System.out.println("Error al insertar");
				// e.printStackTrace();
			}
		} else if (t.equals("enfermera")) {
			try {

				// Prepare the SQL statement
				String insertQuery1 = "INSERT INTO " + "persona" + " (id, nombre, genero) VALUES (?, ?, ?)";
				PreparedStatement preparedStatement1 = conn.prepareStatement(insertQuery1);
				// Set parameter values
				preparedStatement1.setInt(1, 50);
				preparedStatement1.setString(2, "Esta to fasi");
				preparedStatement1.setString(3, "h");

				// Execute the prepared statement
				preparedStatement1.executeUpdate();

				String insertQuery2 = "INSERT INTO " + t + " (id, inventario) VALUES (?,?)";
				PreparedStatement preparedStatement2 = conn.prepareStatement(insertQuery2);
				// Set parameter values
				preparedStatement2.setInt(1, 50);
				preparedStatement2.setString(2, null);
				// Execute the prepared statement
				preparedStatement2.executeUpdate();

				System.out.println("Enfermera creada");

			} catch (SQLException e) {
				System.out.println("Error al insertar");
				// e.printStackTrace();
			}
		}
	}

	public void Select(String... tablaOpcional) {

		String tabla = "";

		if (tablaOpcional.length > 0)
			tabla = tablaOpcional[0];
		else {
			System.out.println("Introduce nombre de tabla para hacer SELECT");
			System.out.println("\nTablas: \n- centro\n" + "- enfermera\n" + "- entrenador\n" + "- pokemon\n"
					+ "- tratamiento\n" + "- salir\n");
			tabla = sc.next();
		}

		switch (tabla) {
		case "centro":
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM centro";

				ResultSet resultSet = statement.executeQuery(query);

				// Process the results
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String localidad = resultSet.getString("localidad");
					double presupuesto = resultSet.getDouble("presupuesto");
					int trabajador = resultSet.getInt("trabajador");
					System.out.println("ID: " + id + ", Nombre: " + nombre + ", Localidad: " + localidad
							+ ", Presupuesto: " + presupuesto + ", Enfermera: " + trabajador);
				}
			} catch (SQLException e) {
				System.out.println("Error al leer");
				// e.printStackTrace();
			}

			break;
		case "enfermera":
			System.out.println("CODIGO ENFERMERA");
			break;
		case "entrenador":
			System.out.println("CODIGO ENTRENADOR");
			break;
		case "pokemon":
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM pokemon";

				ResultSet resultSet = statement.executeQuery(query);

				// Process the results
				while (resultSet.next()) {
					int id = resultSet.getInt("id_poke");
					String nombre = resultSet.getString("nombre");
					double peso = resultSet.getDouble("peso");
					double altura = resultSet.getDouble("altura");
					String tipo = resultSet.getString("tipo");
					int vida = resultSet.getInt("vida");
					String estado = resultSet.getString("estado");
					int id_entrenador = resultSet.getInt("id_entrenador");
					System.out.println("ID: " + id + ", Nombre: " + nombre + ", Peso: " + peso + ", Altura: " + altura
							+ ", Tipo: " + tipo + ", Vida: " + vida + ", Estado: " + estado + ", Id_entrenador: "
							+ id_entrenador);
				}
			} catch (SQLException e) {
				System.out.println("Error al leer la tabla");
				// e.printStackTrace();
			}
			break;
		case "tratamiento":
			System.out.println("CODIGO TRATAMIENTO");
			break;
		case "salir":
			System.out.println("\nVolviendo al menu principal");
			break;
		default:
			System.out.println("Tabla no reconocida");
		}

	}

	public void Update() {
		/*
		 * // Update data String updateQuery =
		 * "UPDATE users SET email = 'johndoe@example.com' WHERE id = 1"; int
		 * rowsUpdated = statement.executeUpdate(updateQuery);
		 * System.out.println(rowsUpdated + " row(s) updated.");
		 */
	}

	public void Delete() {

		/*
		 * // Delete data String deleteQuery = "DELETE FROM users WHERE id = 1"; int
		 * rowsDeleted = statement.executeUpdate(deleteQuery);
		 * System.out.println(rowsDeleted +" row(s) deleted.");
		 */
	}

}
