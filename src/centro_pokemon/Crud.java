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

public class Crud implements CrudInterface {

	private Connection conn = null;
	static Scanner sc = new Scanner(System.in);;

	public Crud() {
		this.conn = Conn.dameConn();
		// if (sc != null) sc.close();
	}

	public void insertCentro(Centro nuevoCentro) {

		try {
			// Prepare the SQL statement
			String insertQuery = "INSERT INTO centro (nombre, localidad, presupuesto, trabajador) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
			// Set parameter values
			preparedStatement.setString(1, nuevoCentro.getNombre());
			preparedStatement.setString(2, nuevoCentro.getLocalidad());
			preparedStatement.setDouble(3, nuevoCentro.getPresupuesto());
			preparedStatement.setInt(4, nuevoCentro.getTrabajador());
			// Execute the prepared statement
			int rowsInserted = preparedStatement.executeUpdate();
			System.out.println(rowsInserted + " row(s) insertados.");

		} catch (SQLException e) {
			System.out.println("Error al insertar");
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
		}
	}

	public void insertPokemon(Pokemon nuevoPokemon) {
		// MAR
	}

	public void insertTratamiento(Tratamiento nuevoTratamiento) {

		try {
			String insertQuery = "INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
			// PEPE
			// Set parameter values
			/*
			 * preparedStatement.setString(1, centroNuevo.getNombre());
			 * preparedStatement.setString(2, centroNuevo.getLocalidad());
			 * preparedStatement.setDouble(3, centroNuevo.getPresupuesto());
			 * preparedStatement.setInt(4, centroNuevo.getTrabajador());
			 */
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
			// JESUS
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
				String sqlTratamiento = "SELECT * FROM tratamiento WHERE id_Tratamiento = ?";
				PreparedStatement statementTratamiento = conn.prepareStatement(sqlTratamiento);

				statementTratamiento.setInt(1, id);

				// Ejecutar la consulta y obtener el resultado
				ResultSet resultSetTratamiento = statementTratamiento.executeQuery();
				if (resultSetTratamiento.next()) {
					tratamiento = new Tratamiento();
					tratamiento.setIdTratamiento(resultSetTratamiento.getInt("id_Tratamiento"));
					tratamiento.setDiagnostico(resultSetTratamiento.getString("diagnostico"));
					tratamiento.setFechaAlta(resultSetTratamiento.getDate("fecha_alta"));
					tratamiento.setFechaBaja(resultSetTratamiento.getDate("fecha_baja"));
					tratamiento.setCosto(resultSetTratamiento.getDouble("costo"));
					tratamiento.setIdPokemon(resultSetTratamiento.getInt("id_poke"));
					tratamiento.setIdEnfermera(resultSetTratamiento.getInt("id_enfermera"));
				}
			} catch (SQLException e) {
				System.out.println("No existe esa ID");
			}
			return tratamiento;

		default:
			System.out.println("No existe tabla para ese objeto");
			return null;
		}
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

	public void updatePokemon() {
		// MAR
	}

	public void updateTratamiento(int id, String campo) {
		try {
			switch (campo) {
			case "id_tratamiento":
				System.out.print("Ingrese el nuevo diagnóstico: ");
				String nuevoDiagnostico = sc.next();
				String updateQueryDiagnostico = "UPDATE tratamiento SET diagnostico=? WHERE id_tratamiento=?";
				PreparedStatement statementDiagnostico = conn.prepareStatement(updateQueryDiagnostico);
				statementDiagnostico.setString(1, nuevoDiagnostico);
				statementDiagnostico.setInt(2, id);
				statementDiagnostico.executeUpdate();
				break;

			case "fecha_alta":
				System.out.print("Ingrese la nueva fecha de alta (YYYY-MM-DD): ");
				String nuevaFechaAlta = sc.next();
				java.sql.Date fechaAlta = java.sql.Date.valueOf(nuevaFechaAlta);
				String updateQueryFechaAlta = "UPDATE tratamiento SET fecha_alta=? WHERE id_tratamiento=?";
				PreparedStatement statementFechaAlta = conn.prepareStatement(updateQueryFechaAlta);
				statementFechaAlta.setDate(1, fechaAlta);
				statementFechaAlta.setInt(2, id);
				statementFechaAlta.executeUpdate();
				break;

			case "fecha_baja":
				System.out.print("Ingrese la nueva fecha de baja (YYYY-MM-DD): ");
				String nuevaFechaBaja = sc.next();
				java.sql.Date fechaBaja = java.sql.Date.valueOf(nuevaFechaBaja);
				String updateQueryFechaBaja = "UPDATE tratamiento SET fecha_baja=? WHERE id_tratamiento=?";
				PreparedStatement statementFechaBaja = conn.prepareStatement(updateQueryFechaBaja);
				statementFechaBaja.setDate(1, fechaBaja);
				statementFechaBaja.setInt(2, id);
				statementFechaBaja.executeUpdate();
				break;

			case "costo":
				System.out.print("Ingrese el nuevo costo: ");
				double nuevoCosto = sc.nextDouble();
				String updateQueryCosto = "UPDATE tratamiento SET costo=? WHERE id_tratamiento=?";
				PreparedStatement statementCosto = conn.prepareStatement(updateQueryCosto);
				statementCosto.setDouble(1, nuevoCosto);
				statementCosto.setInt(2, id);
				statementCosto.executeUpdate();
				break;

			case "id_poke":
				System.out.print("Ingrese el nuevo ID del Pokemon: ");
				int nuevoIdPokemon = sc.nextInt();
				String updateQueryIdPokemon = "UPDATE tratamiento SET id_poke=? WHERE id_tratamiento=?";
				PreparedStatement statementIdPokemon = conn.prepareStatement(updateQueryIdPokemon);
				statementIdPokemon.setInt(1, nuevoIdPokemon);
				statementIdPokemon.setInt(2, id);
				statementIdPokemon.executeUpdate();
				break;

			case "id_enfermera":
				System.out.print("Ingrese el nuevo ID de la Enfermera: ");
				int nuevoIdEnfermera = sc.nextInt();
				String updateQueryIdEnfermera = "UPDATE tratamiento SET id_enfermera=? WHERE id_tratamiento=?";
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

	public void deleteCentro(Centro centro) {
		// JESUS
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

	public void deletePokemon(int id) {
		// MAR
	}

	public void deleteTratamiento(int id) {
        try {
            String deleteQueryTratamiento = "DELETE FROM tratamiento WHERE id_tratamiento=?";
            PreparedStatement statementTratamiento = conn.prepareStatement(deleteQueryTratamiento);
            statementTratamiento.setInt(1, id);
            statementTratamiento.executeUpdate();

            System.out.println("Tratamiento eliminado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void muestraPokemon(int id_entrenador) {
		try {
			String query = "SELECT * FROM pokemon WHERE id_entrenador = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id_entrenador);
			ResultSet resultSet = statement.executeQuery();

			System.out.println("Pokemon(s) del entrenador con ID " + id_entrenador + ":");

			while (resultSet.next()) {
				int id_pokemon = resultSet.getInt("id_poke");
				String nombre = resultSet.getString("nombre");
				System.out.println("ID: " + id_pokemon + ", Nombre: " + nombre);
			}
		} catch (SQLException e) {
			System.out.println("No existe esa ID");
		}

	}

	public void curarPokemon(int id_centro, int id_entrenador, int id_pokemon) {
		System.out.println("DESARROLLAR");

		// Object centro = selectId("centro", id_centro);
		Object entrenador = selectId("entrenador", id_entrenador);
		// Object pokemon = selectId("pokemon", id_pokemon);

	}

}
