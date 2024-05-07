package centro_pokemon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * Clase que permite interactuar con la tabla tratamiento de la base de datos.
 */
public class Tratamiento {

	private Connection conexion;

	/**
	 * Constructor de la clase Tratamiento. Establece la conexión con la base de
	 * datos MySQL.
	 */
	public Tratamiento() {
		// Establecer conexión con la base de datos
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulaPokemon", "root", "Dam23-24");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para insertar un nuevo tratamiento en la base de datos.
	 * 
	 * @param tratamiento Objeto TratamientoInfo que contiene la información del
	 *                    tratamiento a insertar.
	 */
	public void insertarTratamiento(TratamientoInfo tratamiento) {
		try {
			String query = "INSERT INTO tratamiento (diagnostico, fecha_alta, fecha_baja, costo, id_poke, id_enfermera) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, tratamiento.getDiagnostico());
			ps.setDate(2, Date.valueOf(tratamiento.getFechaAlta()));
			ps.setDate(3, Date.valueOf(tratamiento.getFechaBaja()));
			ps.setDouble(4, tratamiento.getCosto());
			ps.setInt(5, tratamiento.getIdPokemon());
			ps.setInt(6, tratamiento.getIdEnfermera());
			ps.executeUpdate();
			ps.close();
			System.out.println("Tratamiento insertado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para actualizar un tratamiento existente en la base de datos.
	 * 
	 * @param tratamiento Objeto TratamientoInfo que contiene la nueva información
	 *                    del tratamiento.
	 */
	public void actualizarTratamiento(TratamientoInfo tratamiento) {
		try {
			String query = "UPDATE tratamiento SET diagnostico=?, fecha_alta=?, fecha_baja=?, costo=?, id_poke=?, id_enfermera=? WHERE id_tratamiento=?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, tratamiento.getDiagnostico());
			ps.setDate(2, Date.valueOf(tratamiento.getFechaAlta()));
			ps.setDate(3, Date.valueOf(tratamiento.getFechaBaja()));
			ps.setDouble(4, tratamiento.getCosto());
			ps.setInt(5, tratamiento.getIdPokemon());
			ps.setInt(6, tratamiento.getIdEnfermera());
			ps.setInt(7, tratamiento.getIdTratamiento());
			ps.executeUpdate();
			ps.close();
			System.out.println("Tratamiento actualizado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para eliminar un tratamiento de la base de datos.
	 * 
	 * @param idTratamiento ID del tratamiento a eliminar.
	 */
	public void eliminarTratamiento(int idTratamiento) {
		try {
			String query = "DELETE FROM tratamiento WHERE id_tratamiento=?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idTratamiento);
			ps.executeUpdate();
			ps.close();
			System.out.println("Tratamiento eliminado correctamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para obtener todos los tratamientos de la base de datos y mostrarlos
	 * en la consola.
	 */
	public void obtenerTratamientos() {
		try {
			String query = "SELECT * FROM tratamiento";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println("ID Tratamiento: " + rs.getInt("id_tratamiento") + ", Diagnóstico: "
						+ rs.getString("diagnostico") + ", Fecha Alta: " + rs.getDate("fecha_alta").toLocalDate()
						+ ", Fecha Baja: " + rs.getDate("fecha_baja").toLocalDate() + ", Costo: "
						+ rs.getDouble("costo") + ", ID Pokemon: " + rs.getInt("id_poke") + ", ID Enfermera: "
						+ rs.getInt("id_enfermera"));
			}

			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para obtener un tratamiento por su ID y mostrarlo en la consola.
	 * 
	 * @param idTratamiento ID del tratamiento a buscar.
	 */
	public void obtenerTratamientoPorId(int idTratamiento) {
		try {
			String query = "SELECT * FROM tratamiento WHERE id_tratamiento=?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idTratamiento);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("ID Tratamiento: " + rs.getInt("id_tratamiento") + ", Diagnóstico: "
						+ rs.getString("diagnostico") + ", Fecha Alta: " + rs.getDate("fecha_alta").toLocalDate()
						+ ", Fecha Baja: " + rs.getDate("fecha_baja").toLocalDate() + ", Costo: "
						+ rs.getDouble("costo") + ", ID Pokemon: " + rs.getInt("id_poke") + ", ID Enfermera: "
						+ rs.getInt("id_enfermera"));
			} else {
				System.out.println("No se encontró ningún tratamiento con el ID proporcionado.");
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clase que representa la información de un tratamiento.
	 */
	public static class TratamientoInfo {
		private int idTratamiento;
		private String diagnostico;
		private LocalDate fechaAlta;
		private LocalDate fechaBaja;
		private double costo;
		private int idPokemon;
		private int idEnfermera;

		public TratamientoInfo(int idTratamiento, String diagnostico, LocalDate fechaAlta, LocalDate fechaBaja,
				double costo, int idPokemon, int idEnfermera) {
			this.idTratamiento = idTratamiento;
			this.diagnostico = diagnostico;
			this.fechaAlta = fechaAlta;
			this.fechaBaja = fechaBaja;
			this.costo = costo;
			this.idPokemon = idPokemon;
			this.idEnfermera = idEnfermera;
		}

		public int getIdTratamiento() {
			return idTratamiento;
		}

		public String getDiagnostico() {
			return diagnostico;
		}

		public LocalDate getFechaAlta() {
			return fechaAlta;
		}

		public LocalDate getFechaBaja() {
			return fechaBaja;
		}

		public double getCosto() {
			return costo;
		}

		public int getIdPokemon() {
			return idPokemon;
		}

		public int getIdEnfermera() {
			return idEnfermera;
		}
	}

	/**
	 * Método main de prueba.
	 * 
	 * @param args Argumentos de la línea de comandos.
	 */
	public static void main(String[] args) {
		Tratamiento tratamiento = new Tratamiento();

		// Insertar un nuevo tratamiento
		tratamiento.insertarTratamiento(new TratamientoInfo(0, "Parálisis temporal", LocalDate.of(2024, 4, 15),
				LocalDate.of(2024, 4, 20), 50, 1, 1));

		// Actualizar un tratamiento existente
		tratamiento.actualizarTratamiento(new TratamientoInfo(1, "Intoxicación por veneno", LocalDate.of(2024, 4, 16),
				LocalDate.of(2024, 4, 21), 40, 2, 2));

		// Eliminar un tratamiento
		tratamiento.eliminarTratamiento(1);

		// Obtener todos los tratamientos
		tratamiento.obtenerTratamientos();

		// Obtener un tratamiento por su ID
		tratamiento.obtenerTratamientoPorId(2);
	}
}
