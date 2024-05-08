package centro_pokemon;

public class Entrenador extends Persona {

	private int numMedallas;
	private double saldo;

	public Entrenador() {
	}

	public int getNumMedallas() {
		return numMedallas;
	}

	public void setNumMedallas(int numMedallas) {
		this.numMedallas = numMedallas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Entrenador [id = " + getId() + ", nombre = " + getNombre() + ", genero = " + getGenero()
				+ ", medallas = " + numMedallas + ", saldo = " + saldo + "]";
	}

}
