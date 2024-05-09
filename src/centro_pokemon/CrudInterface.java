package centro_pokemon;

public interface CrudInterface {

	public void insertCentro(Centro nuevoCentro);

	public void insertEnfermera(Enfermera nuevaEnfermera);

	public void insertEntrenador(Entrenador nuevoEntrenador);

	public void insertPokemon(Pokemon nuevoPokemon);

	public void insertTratamiento(Tratamiento nuevoTratamiento);

	public void select(String... tablaOpcional);

	public Object selectId(String tabla, int id);

	// public void updateCentro(Centro centro);
	public void updateEnfermera(int id, String campo);

	public void updateEntrenador(int id, String campo);
	// public void updatePokemon(Tratamiento tratamiento);
	// public void updateTratamiento(Tratamiento tratamiento);

	// public void deleteCentro(Centro centro);
	public void deleteEnfermera(int id);

	public void deleteEntrenador(int id);
	// public void deletePokemon(int id);
	// public void deleteTratamiento(Tratamiento tratamiento);

	public void muestraPokemon(int id_entrenador);

	public void curarPokemon(int id_centro, int id_entrenador, int id_pokemon);
}
