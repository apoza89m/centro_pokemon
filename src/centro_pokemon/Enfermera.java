package centro_pokemon;

public class Enfermera extends Persona {

	private int numPokemonTratados;

	public Enfermera() {
	}

	public int getNumPokemonTratados() {
		return numPokemonTratados;
	}

	public void setNumPokemonTratados(int numPokemonTratados) {
		this.numPokemonTratados = numPokemonTratados;
	}

	@Override
	public String toString() {
		return "Enfermera [id = " + getId() + ", nombre = " + getNombre() + ", genero = " + getGenero()
				+ ", Numero de pokemon tratados = " + numPokemonTratados + "]";
	}

}
