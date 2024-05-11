package centro_pokemon;

public interface CrudInterface {

	public void insertCentro(Centro nuevoCentro);

	public void insertEnfermera(Enfermera nuevaEnfermera);

	public void insertEntrenador(Entrenador nuevoEntrenador);

	// public void insertPokemon(Pokemon nuevoPokemon);

	public void insertTratamiento(Tratamiento nuevoTratamiento);

	public void select(String... tablaOpcional);

	public Object selectId(String tabla, int id);
	// Falta select en tabla pokemon

	public void updateCentro(int id, String campo);

	public void updateEnfermera(int id, String campo);

	public void updateEntrenador(int id, String campo);

	// public void updatePokemon(Tratamiento tratamiento);
	public void updateTratamiento(int id, String campo);

	public void deleteCentro(int id);

	public void deleteEnfermera(int id);

	public void deleteEntrenador(int id);

	// public void deletePokemon(int id);
	public void deleteTratamiento(int id);

	public void muestraPokemon(int id_entrenador);

	// public void curarPokemon(int id_centro, int id_entrenador, int id_pokemon);
}
