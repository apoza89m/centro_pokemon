package centro_pokemon;

import java.sql.Date;

public class Tratamiento {
	/**
	 * Clase que representa la información de un tratamiento.
	 */
	private int idTratamiento;
	private String diagnostico;
	private Date fechaAlta;
	private Date fechaBaja;
	private double costo;
	private int idPokemon;
	private int idEnfermera;

	public Tratamiento() {
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setFechaBaja(Date fechaBaja) {
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

	public int getIdTratamiento() {
		return idTratamiento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Date getFechaBaja() {
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

	@Override
	public String toString() {
		return "Tratamiento [idTratamiento=" + idTratamiento + ", diagnostico=" + diagnostico + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", costo=" + costo + ", idPokemon=" + idPokemon
				+ ", idEnfermera=" + idEnfermera + "]";
	}

}
