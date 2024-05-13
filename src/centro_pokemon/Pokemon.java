package centro_pokemon;

public class Pokemon {

	private int idPoke;
	private String nombre;
	private double peso;
	private double altura;
	private String tipo;
	private int vida;
	private String estado;
	private int idEntrenador;

	public Pokemon() {
	}

	public int getIdPoke() {
		return idPoke;
	}

	public void setIdPoke(int idPoke) {
		this.idPoke = idPoke;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String l) {
		this.nombre = l;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double b) {
		this.altura = b;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	@Override
	public String toString() {
		return "Pokemon [idPoke=" + idPoke + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + ", tipo="
				+ tipo + ", vida=" + vida + ", estado=" + estado + ", idEntrenador=" + idEntrenador + "]";
	}

	public String getGenero() {
		// TODO Auto-generated method stub
		return null;
	}
}
