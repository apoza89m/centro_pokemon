package centro_pokemon;

import java.time.LocalDate;

public class Tratamiento {
	/**
	 * Clase que representa la información de un tratamiento.
	 */
	private int idTratamiento;
	private String diagnostico;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private double costo;
	private int idPokemon;
	private int idEnfermera;

	public Tratamiento() {
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

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}

	public void setIdEnfermera(int idEnfermera) {
		this.idEnfermera = idEnfermera;
	}

}
