package centro_pokemon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @name Crud.java
 * @purpose BD
 * @author Group 4
 * @version 1.0
 */

public class Crud {

	private Connection conn = null;
	Scanner sc;

	public Crud() {
		this.conn = Conn.dameConn();
		sc = new Scanner(System.in);
		// if (sc != null) sc.close();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
		
	public Scanner getSc() {
		return sc;
	}
	
	public void insertCentro(Centro centroNuevo) {

        try {
            // Prepare the SQL statement
            String insertQuery = "INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            // Set parameter values
            preparedStatement.setString(1, centroNuevo.getNombre());
            preparedStatement.setString(2, centroNuevo.getLocalidad());
            preparedStatement.setDouble(3, centroNuevo.getPresupuesto());
            preparedStatement.setInt(4, centroNuevo.getTrabajador());
            // Execute the prepared statement
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) insertados.");

        } catch (SQLException e) {
            System.out.println("Error al insertar");
            // e.printStackTrace();
        }
}
	public void insertTratamiento(Tratamiento tratamientoNuevo) {

		try {
			String insertQuery = "INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            //PEPE
            // Set parameter values
            /*preparedStatement.setString(1, centroNuevo.getNombre());
            preparedStatement.setString(2, centroNuevo.getLocalidad());
            preparedStatement.setDouble(3, centroNuevo.getPresupuesto());
            preparedStatement.setInt(4, centroNuevo.getTrabajador());*/
            // Execute the prepared statement
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) insertados.");

        } catch (SQLException e) {
            System.out.println("Error al insertar");
            // e.printStackTrace();
        }
	}
	public void insertEnfermera(Enfermera enfermeraNueva) {

        try {
            // Prepare the SQL statement
            String insertQuery = "INSERT INTO enfermera (nombre, localidad, presupuesto, trabajador) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            // Set parameter values
            preparedStatement.setString(1, enfermeraNueva.getNombre());
            /*preparedStatement.setString(2, enfermeraNueva.getLocalidad());
            preparedStatement.setDouble(3, enfermeraNueva.getPresupuesto());
            preparedStatement.setInt(4, enfermeraNueva.getTrabajador());*/
            // Execute the prepared statement
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) insertados.");

        } catch (SQLException e) {
            System.out.println("Error al insertar");
            // e.printStackTrace();
        }
}

	public void select(String... tablaOpcional) { // String... permite 0 o mas parametros, array[]

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
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM persona JOIN enfermera ON persona.id = enfermera.id";

				ResultSet resultSet = statement.executeQuery(query);

				// Process the results
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					char genero = resultSet.getString("genero").charAt(0);
							
					System.out.println("ID: " + id + ", Nombre: " + nombre + ", genero: " + genero
							+ ", Inventario: ");
				}
			} catch (SQLException e) {
				System.out.println("Error al leer");
				// e.printStackTrace();
			}
			break;
		case "entrenador":
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM persona JOIN entrenador ON persona.id = entrenador.id";

				ResultSet resultSet = statement.executeQuery(query);

				// Process the results
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					char genero = resultSet.getString("genero").charAt(0);
					int numMedallas = resultSet.getInt("num_medallas");
					int saldo = resultSet.getInt("saldo");
					
					

					System.out.println("ID: " + id + ", Nombre: " + nombre + ", genero: " + genero
							+ ", Numero de medallas: " + numMedallas +  ", pokedex: " + 
							", depot: " +  ", saldo: " + saldo);
				}
			} catch (SQLException e) {
				System.out.println("Error al leer");
				// e.printStackTrace();
			}
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
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM tratamiento";

				ResultSet rs = statement.executeQuery(query);

				// Process the results
				while (rs.next()) {
					System.out.println("ID Tratamiento: " + rs.getInt("id_tratamiento") + ", Diagnóstico: "
							+ rs.getString("diagnostico") + ", Fecha Alta: " + rs.getDate("fecha_alta").toLocalDate()
							+ ", Fecha Baja: " + rs.getDate("fecha_baja").toLocalDate() + ", Costo: "
							+ rs.getDouble("costo") + ", ID Pokemon: " + rs.getInt("id_poke") + ", ID Enfermera: "
							+ rs.getInt("id_enfermera"));
				}

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "salir":
			System.out.println("\nVolviendo al menu principal");
			break;
		default:
			System.out.println("Tabla no reconocida");
		}

	}

	//ROBE
	public boolean selectId(String tabla, int idSelect) {
		
		// int idSelect = objeto.getId();
		
		switch (tabla) {
		case "centro":
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM centro WHERE id = " + idSelect;

				ResultSet resultSet = statement.executeQuery(query);

				// Process the results
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String localidad = resultSet.getString("localidad");
					double presupuesto = resultSet.getDouble("presupuesto");
					int trabajador = resultSet.getInt("trabajador");
					System.out.println("ID: " + id + ", Nombre: " + nombre + ", Localidad: " + localidad + ", Presupuesto: " + presupuesto
							+ ", Trabajador: " + trabajador);
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error al leer la tabla");
				// e.printStackTrace();
			}
			break;
		case "pokemon":
			try {
				// Create a statement
				Statement statement = conn.createStatement();
				// Execute a query
				String query = "SELECT * FROM pokemon WHERE id_poke = " + idSelect;

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
					return true;
				}
			} catch (SQLException e) {
				System.out.println("Error al leer la tabla");
				// e.printStackTrace();
			}
			break;
			
		default:
			System.out.println("No existe tabla para ese objeto");
			return false;
		}
		return false;

	}

	public void update() {
		/*
		 * // Update data String updateQuery =
		 * "UPDATE users SET email = 'johndoe@example.com' WHERE id = 1"; int
		 * rowsUpdated = statement.executeUpdate(updateQuery);
		 * System.out.println(rowsUpdated + " row(s) updated.");
		 */
	}
	
	public void updateCentro(Centro centro) {
		try {
			// Execute a query
			//JESUS
			String updateQuery = "UPDATE tratamiento SET diagnostico=?, fecha_alta=?, fecha_baja=?, costo=?, id_poke=?, id_enfermera=? WHERE id_tratamiento=?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
           /* preparedStatement.setString(1, tratamiento.getDiagnostico());
            preparedStatement.setDate(2, Date.valueOf(tratamiento.getFechaAlta()));
            preparedStatement.setDate(3, Date.valueOf(tratamiento.getFechaBaja()));
            preparedStatement.setDouble(4, tratamiento.getCosto());
            preparedStatement.setInt(5, tratamiento.getIdPokemon());
            preparedStatement.setInt(6, tratamiento.getIdEnfermera());
            preparedStatement.setInt(7, tratamiento.getIdTratamiento());
            preparedStatement.executeUpdate();
            preparedStatement.close();*/
			System.out.println("Tratamiento actualizado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTratamiento(Tratamiento tratamiento) {
		try {
			// Execute a query
			//PEPE
			String updateQuery = "UPDATE tratamiento SET diagnostico=?, fecha_alta=?, fecha_baja=?, costo=?, id_poke=?, id_enfermera=? WHERE id_tratamiento=?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
           /* preparedStatement.setString(1, tratamiento.getDiagnostico());
            preparedStatement.setDate(2, Date.valueOf(tratamiento.getFechaAlta()));
            preparedStatement.setDate(3, Date.valueOf(tratamiento.getFechaBaja()));
            preparedStatement.setDouble(4, tratamiento.getCosto());
            preparedStatement.setInt(5, tratamiento.getIdPokemon());
            preparedStatement.setInt(6, tratamiento.getIdEnfermera());
            preparedStatement.setInt(7, tratamiento.getIdTratamiento());
            preparedStatement.executeUpdate();
            preparedStatement.close();*/
			System.out.println("Tratamiento actualizado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {

		/*
		 * // Delete data String deleteQuery = "DELETE FROM users WHERE id = 1"; int
		 * rowsDeleted = statement.executeUpdate(deleteQuery);
		 * System.out.println(rowsDeleted +" row(s) deleted.");
		 */
	}
	
	public void deleteCentro(Centro centro) {
		try {
			String deleteQuery = "DELETE FROM tratamiento WHERE id_tratamiento=?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			//JESUS
			/*
			preparedStatement.setInt(1, tratamiento.getIdTratamiento());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Tratamiento eliminado correctamente.");*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTratamiento(Tratamiento tratamiento) {
		try {
			String deleteQuery = "DELETE FROM tratamiento WHERE id_tratamiento=?";
			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, tratamiento.getIdTratamiento());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Tratamiento eliminado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
