package centro_pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

	public void insertEnfermera(Enfermera nuevaEnfermera) {

		try {
			// Prepare the SQL statement
			String insertQueryPersona = "INSERT INTO persona (id, nombre, genero) VALUES (?, ?, ?)";
			String insertQueryEnfermera = "INSERT INTO enfermera (id, num_pokemon_tratados) VALUES (?, ?)";
			PreparedStatement preparedStatementPersona = conn.prepareStatement(insertQueryPersona);
			// Set parameter values
			preparedStatementPersona.setInt(1, nuevaEnfermera.getId());
			preparedStatementPersona.setString(2, nuevaEnfermera.getNombre());
			preparedStatementPersona.setString(3, nuevaEnfermera.getGenero());
			// Execute the prepared statement
			int rowsInserted1 = preparedStatementPersona.executeUpdate();
			System.out.println(rowsInserted1 + " row(s) insertados.");

			PreparedStatement preparedStatementEnfermera = conn.prepareStatement(insertQueryEnfermera);
			// Set parameter values
			preparedStatementEnfermera.setInt(1, nuevaEnfermera.getId());
			preparedStatementEnfermera.setInt(2, nuevaEnfermera.getNumPokemonTratados());
			// Execute the prepared statement
			int rowsInserted2 = preparedStatementEnfermera.executeUpdate();
			System.out.println(rowsInserted2 + " row(s) insertados.");

		} catch (SQLException e) {
			System.out.println("Error al insertar");
			// e.printStackTrace();
		}
	}

	public void insertEntrenador(Entrenador nuevoEntrenador) {

		try {
			// Prepare the SQL statement
			String insertQueryPersona = "INSERT INTO persona (id, nombre, genero) VALUES (?, ?, ?)";
			String insertQueryEntrenador = "INSERT INTO entrenador (id, num_medallas, saldo) VALUES (?, ?, ?)";
			PreparedStatement preparedStatementPersona = conn.prepareStatement(insertQueryPersona);
			// Set parameter values
			preparedStatementPersona.setInt(1, nuevoEntrenador.getId());
			preparedStatementPersona.setString(2, nuevoEntrenador.getNombre());
			preparedStatementPersona.setString(3, nuevoEntrenador.getGenero());
			// Execute the prepared statement
			int rowsInserted1 = preparedStatementPersona.executeUpdate();
			System.out.println(rowsInserted1 + " row(s) insertados.");

			PreparedStatement preparedStatementEntrenador = conn.prepareStatement(insertQueryEntrenador);
			// Set parameter values
			preparedStatementEntrenador.setInt(1, nuevoEntrenador.getId());
			preparedStatementEntrenador.setInt(2, nuevoEntrenador.getNumMedallas());
			preparedStatementEntrenador.setDouble(3, nuevoEntrenador.getSaldo());
			// Execute the prepared statement
			int rowsInserted2 = preparedStatementEntrenador.executeUpdate();
			System.out.println(rowsInserted2 + " row(s) insertados.");

		} catch (SQLException e) {
			System.out.println("Error al insertar");
			// e.printStackTrace();
		}
	}

	public void insertTratamiento(Tratamiento nuevoTratamiento) {

		try {
			// Preparar la consulta SQL
			String insertQueryTratamiento = "INSERT INTO tratamiento (idTratamiento, diagnostico, fechaAlta, fechaBaja, costo, idPokemon, idEnfermera) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatementTratamiento = conn.prepareStatement(insertQueryTratamiento);

			// Establecer los valores de los parámetros
			preparedStatementTratamiento.setInt(1, nuevoTratamiento.getIdTratamiento());
			preparedStatementTratamiento.setString(2, nuevoTratamiento.getDiagnostico());
			preparedStatementTratamiento.setDate(3, java.sql.Date.valueOf(nuevoTratamiento.getFechaAlta()));
			preparedStatementTratamiento.setDate(4, java.sql.Date.valueOf(nuevoTratamiento.getFechaBaja()));
			preparedStatementTratamiento.setDouble(5, nuevoTratamiento.getCosto());
			preparedStatementTratamiento.setInt(6, nuevoTratamiento.getIdPokemon());
			preparedStatementTratamiento.setInt(7, nuevoTratamiento.getIdEnfermera());

			// Ejecutar la consulta preparada
			int rowsInserted = preparedStatementTratamiento.executeUpdate();
			System.out.println(rowsInserted + " fila(s) insertada(s).");

		} catch (SQLException e) {
			System.out.println("Error al insertar el tratamiento");
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
					int numPokemonTratados = resultSet.getInt("num_pokemon_tratados");
					System.out.println("ID: " + id + ", Nombre: " + nombre + ", genero: " + genero
							+ ", Numero de pokemon tratados: " + numPokemonTratados);
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
					double saldo = resultSet.getDouble("saldo");

					System.out.println("ID: " + id + ", Nombre: " + nombre + ", genero: " + genero
							+ ", Numero de medallas: " + numMedallas + ", saldo: " + saldo);
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

	public Object selectId(String tabla, int id) {

		switch (tabla) {
		case "centro":
			// CODIGO JESUS
		case "enfermera":
			Enfermera enfermera = null;
			try {
				// Preparar la consulta SQL
				String sqlPersona = "SELECT * FROM persona WHERE id = ?";
				String sqlEnfermera = "SELECT * FROM enfermera WHERE id = ?";
				PreparedStatement statementPersona = conn.prepareStatement(sqlPersona);
				PreparedStatement statementEnfermera = conn.prepareStatement(sqlEnfermera);

				statementPersona.setInt(1, id);
				statementEnfermera.setInt(1, id);

				// Ejecutar la consulta y obtener el resultado
				ResultSet resultSetPersona = statementPersona.executeQuery();
				if (resultSetPersona.next()) {
					enfermera = new Enfermera();
					enfermera.setId(resultSetPersona.getInt("id"));
					enfermera.setNombre(resultSetPersona.getString("nombre"));
					enfermera.setGenero(resultSetPersona.getString("genero"));
				}

				ResultSet resultSetEnfermera = statementEnfermera.executeQuery();
				if (resultSetEnfermera.next()) {
					enfermera.setNumPokemonTratados(resultSetEnfermera.getInt("num_pokemon_tratados"));
				}
			} catch (SQLException e) {
				System.out.println("No existe esa ID");
			}
			return enfermera;

		case "entrenador":
			Entrenador entrenador = null;
			try {
				// Preparar la consulta SQL
				String sqlPersona = "SELECT * FROM persona WHERE id = ?";
				String sqlEntrenador = "SELECT * FROM entrenador WHERE id = ?";
				PreparedStatement statementPersona = conn.prepareStatement(sqlPersona);
				PreparedStatement statementEntrenador = conn.prepareStatement(sqlEntrenador);

				statementPersona.setInt(1, id);
				statementEntrenador.setInt(1, id);

				// Ejecutar la consulta y obtener el resultado
				ResultSet resultSetPersona = statementPersona.executeQuery();
				if (resultSetPersona.next()) {
					entrenador = new Entrenador();
					entrenador.setId(resultSetPersona.getInt("id"));
					entrenador.setNombre(resultSetPersona.getString("nombre"));
					entrenador.setGenero(resultSetPersona.getString("genero"));
				}

				ResultSet resultSetEntrenador = statementEntrenador.executeQuery();
				if (resultSetEntrenador.next()) {
					entrenador.setNumMedallas(resultSetEntrenador.getInt("num_medallas"));
					entrenador.setSaldo(resultSetEntrenador.getDouble("saldo"));
				}
			} catch (SQLException e) {
				System.out.println("No existe esa ID");
			}
			return entrenador;

		case "pokemon":
			// CODIGO Mar

		case "tratamiento":
			Tratamiento tratamiento = null;
			try {
				// Preparar la consulta SQL
				String sqlTratamiento = "SELECT * FROM tratamiento WHERE idTratamiento = ?";
				PreparedStatement statementTratamiento = conn.prepareStatement(sqlTratamiento);

				statementTratamiento.setInt(1, id);

				// Ejecutar la consulta y obtener el resultado
				ResultSet resultSetTratamiento = statementTratamiento.executeQuery();
				if (resultSetTratamiento.next()) {
					tratamiento = new Tratamiento();
					tratamiento.setIdTratamiento(resultSetTratamiento.getInt("idTratamiento"));
					tratamiento.setDiagnostico(resultSetTratamiento.getString("diagnostico"));
					tratamiento.setFechaAlta(resultSetTratamiento.getDate("fechaAlta").toLocalDate());
					tratamiento.setFechaBaja(resultSetTratamiento.getDate("fechaBaja").toLocalDate());
					tratamiento.setCosto(resultSetTratamiento.getDouble("costo"));
					tratamiento.setIdPokemon(resultSetTratamiento.getInt("idPokemon"));
					tratamiento.setIdEnfermera(resultSetTratamiento.getInt("idEnfermera"));
				}
			} catch (SQLException e) {
				System.out.println("No existe esa ID");
			}
			return tratamiento;
		default:
			System.out.println("Tabla no válida");
			return null;
		}
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
		// JESUS

	}

	public void updateEnfermera(int id, String campo) {
		try {
			switch (campo) {

			case "nombre":
				System.out.print("Ingrese el nuevo nombre: ");
				String nuevoNombre = sc.next();
				String updateQueryNombre = "UPDATE persona SET nombre=? WHERE id=?";
				PreparedStatement statementNombre = conn.prepareStatement(updateQueryNombre);
				statementNombre.setString(1, nuevoNombre);
				statementNombre.setInt(2, id);
				statementNombre.executeUpdate();
				break;

			case "genero":
				System.out.print("Ingrese el nuevo genero(h/m): ");
				String nuevoGenero = sc.next();
				String updateQueryGenero = "UPDATE persona SET genero=? WHERE id=?";
				PreparedStatement statementGenero = conn.prepareStatement(updateQueryGenero);
				statementGenero.setString(1, nuevoGenero);
				statementGenero.setInt(2, id);
				statementGenero.executeUpdate();
				break;

			case "num_pokemon_tratados":
				System.out.print("Ingrese el nuevo numero de pokemon tratados: ");
				int nuevoNum = sc.nextInt();
				String updateQueryNum = "UPDATE enfermera SET num_pokemon_tratados=? WHERE id=?";
				PreparedStatement statementNum = conn.prepareStatement(updateQueryNum);
				statementNum.setInt(1, nuevoNum);
				statementNum.setInt(2, id);
				statementNum.executeUpdate();
				break;

			default:
				System.out.println("Campo no valido.");
				break;
			}
			System.out.println("Actualizado correctamente.");
			System.out.println(selectId("enfermera", id));
		} catch (SQLException e) {
			System.out.println("Error al modificar");
		}
	}

	public void updateEntrenador(int id, String campo) {
		try {
			switch (campo) {

			case "nombre":
				System.out.print("Ingrese el nuevo nombre: ");
				String nuevoNombre = sc.next();
				String updateQueryNombre = "UPDATE persona SET nombre=? WHERE id=?";
				PreparedStatement statementNombre = conn.prepareStatement(updateQueryNombre);
				statementNombre.setString(1, nuevoNombre);
				statementNombre.setInt(2, id);
				statementNombre.executeUpdate();
				break;

			case "genero":
				System.out.print("Ingrese el nuevo genero(h/m): ");
				String nuevoGenero = sc.next();
				String updateQueryGenero = "UPDATE persona SET genero=? WHERE id=?";
				PreparedStatement statementGenero = conn.prepareStatement(updateQueryGenero);
				statementGenero.setString(1, nuevoGenero);
				statementGenero.setInt(2, id);
				statementGenero.executeUpdate();
				break;

			case "num_medallas":
				System.out.print("Ingrese el nuevo numero de medallas: ");
				int nuevoNum = sc.nextInt();
				String updateQueryNum = "UPDATE entrenador SET num_medallas=? WHERE id=?";
				PreparedStatement statementNum = conn.prepareStatement(updateQueryNum);
				statementNum.setInt(1, nuevoNum);
				statementNum.setInt(2, id);
				statementNum.executeUpdate();
				break;

			case "saldo":
				System.out.print("Ingrese el nuevo saldo: ");
				double nuevoSaldo = sc.nextDouble();
				String updateQuerySaldo = "UPDATE entrenador SET saldo=? WHERE id=?";
				PreparedStatement statementSaldo = conn.prepareStatement(updateQuerySaldo);
				statementSaldo.setDouble(1, nuevoSaldo);
				statementSaldo.setInt(2, id);
				statementSaldo.executeUpdate();
				break;

			default:
				System.out.println("Campo no valido.");
				break;
			}
			System.out.println("Actualizado correctamente.");
			System.out.println(selectId("entrenador", id));
		} catch (SQLException e) {
			System.out.println("Error al modificar");
		}
	}

	public void updatePokemon(Tratamiento tratamiento) {
		// MAR
	}

	public void updateTratamiento(int id, String campo) {
		try {
			switch (campo) {
			case "diagnostico":
				System.out.print("Ingrese el nuevo diagnóstico: ");
				String nuevoDiagnostico = sc.next();
				String updateQueryDiagnostico = "UPDATE tratamiento SET diagnostico=? WHERE idTratamiento=?";
				PreparedStatement statementDiagnostico = conn.prepareStatement(updateQueryDiagnostico);
				statementDiagnostico.setString(1, nuevoDiagnostico);
				statementDiagnostico.setInt(2, id);
				statementDiagnostico.executeUpdate();
				break;

			case "fechaAlta":
				System.out.print("Ingrese la nueva fecha de alta (YYYY-MM-DD): ");
				String nuevaFechaAlta = sc.next();
				LocalDate fechaAlta = LocalDate.parse(nuevaFechaAlta);
				String updateQueryFechaAlta = "UPDATE tratamiento SET fechaAlta=? WHERE idTratamiento=?";
				PreparedStatement statementFechaAlta = conn.prepareStatement(updateQueryFechaAlta);
				statementFechaAlta.setDate(1, java.sql.Date.valueOf(fechaAlta));
				statementFechaAlta.setInt(2, id);
				statementFechaAlta.executeUpdate();
				break;

			case "fechaBaja":
				System.out.print("Ingrese la nueva fecha de baja (YYYY-MM-DD): ");
				String nuevaFechaBaja = sc.next();
				LocalDate fechaBaja = LocalDate.parse(nuevaFechaBaja);
				String updateQueryFechaBaja = "UPDATE tratamiento SET fechaBaja=? WHERE idTratamiento=?";
				PreparedStatement statementFechaBaja = conn.prepareStatement(updateQueryFechaBaja);
				statementFechaBaja.setDate(1, java.sql.Date.valueOf(fechaBaja));
				statementFechaBaja.setInt(2, id);
				statementFechaBaja.executeUpdate();
				break;

			case "costo":
				System.out.print("Ingrese el nuevo costo: ");
				double nuevoCosto = sc.nextDouble();
				String updateQueryCosto = "UPDATE tratamiento SET costo=? WHERE idTratamiento=?";
				PreparedStatement statementCosto = conn.prepareStatement(updateQueryCosto);
				statementCosto.setDouble(1, nuevoCosto);
				statementCosto.setInt(2, id);
				statementCosto.executeUpdate();
				break;

			case "idPokemon":
				System.out.print("Ingrese el nuevo ID del Pokemon: ");
				int nuevoIdPokemon = sc.nextInt();
				String updateQueryIdPokemon = "UPDATE tratamiento SET idPokemon=? WHERE idTratamiento=?";
				PreparedStatement statementIdPokemon = conn.prepareStatement(updateQueryIdPokemon);
				statementIdPokemon.setInt(1, nuevoIdPokemon);
				statementIdPokemon.setInt(2, id);
				statementIdPokemon.executeUpdate();
				break;

			case "idEnfermera":
				System.out.print("Ingrese el nuevo ID de la Enfermera: ");
				int nuevoIdEnfermera = sc.nextInt();
				String updateQueryIdEnfermera = "UPDATE tratamiento SET idEnfermera=? WHERE idTratamiento=?";
				PreparedStatement statementIdEnfermera = conn.prepareStatement(updateQueryIdEnfermera);
				statementIdEnfermera.setInt(1, nuevoIdEnfermera);
				statementIdEnfermera.setInt(2, id);
				statementIdEnfermera.executeUpdate();
				break;

			default:
				System.out.println("Campo no válido.");
				break;
			}
			System.out.println("Actualizado correctamente.");
			System.out.println(selectId("tratamiento", id));
		} catch (SQLException e) {
			System.out.println("Error al modificar");
			// e.printStackTrace();
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

			// JESUS
			String deleteQuery = "DELETE FROM tratamiento WHERE id_tratamiento=?";

			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
			/*
			 * preparedStatement.setInt(1, tratamiento.getIdTratamiento());
			 * preparedStatement.executeUpdate(); preparedStatement.close();
			 * System.out.println("Tratamiento eliminado correctamente.");
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEnfermera(int id) {
		try {
			String deleteQueryEnfermera = "DELETE FROM enfermera WHERE id=?";
			String deleteQueryPersona = "DELETE FROM persona WHERE id=?";

			PreparedStatement statementEnfermera = conn.prepareStatement(deleteQueryEnfermera);
			statementEnfermera.setInt(1, id);
			statementEnfermera.executeUpdate();

			PreparedStatement statementPersona = conn.prepareStatement(deleteQueryPersona);
			statementPersona.setInt(1, id);
			statementPersona.executeUpdate();

			System.out.println("Eliminacion correcta");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEntrenador(int id) {
		try {

			String updateQueryPokemon = "UPDATE pokemon SET id_entrenador = NULL WHERE id_entrenador = ?";
			String deleteQueryEntrenador = "DELETE FROM entrenador WHERE id=?";
			String deleteQueryPersona = "DELETE FROM persona WHERE id=?";

			// Hay que updatear todos los pokemon con FK de ese id_entrenador
			PreparedStatement statementPokemon = conn.prepareStatement(updateQueryPokemon);
			statementPokemon.setInt(1, id);
			statementPokemon.executeUpdate();

			PreparedStatement statementEntrenador = conn.prepareStatement(deleteQueryEntrenador);
			statementEntrenador.setInt(1, id);
			statementEntrenador.executeUpdate();

			PreparedStatement statementPersona = conn.prepareStatement(deleteQueryPersona);
			statementPersona.setInt(1, id);
			statementPersona.executeUpdate();

			System.out.println("Eliminacion correcta");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTratamiento(int id) {
		try {
			String deleteQueryTratamiento = "DELETE FROM tratamiento WHERE idTratamiento=?";
			PreparedStatement statementTratamiento = conn.prepareStatement(deleteQueryTratamiento);
			statementTratamiento.setInt(1, id);
			statementTratamiento.executeUpdate();

			System.out.println("Tratamiento eliminado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
