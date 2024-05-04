package centro_pokemon;

public class Centro {

    private int id;
    private String nombre;
    private String localidad;
    private Double presupuesto;
    private int trabajador;


    public Centro() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getLocalidad() {
        return localidad;
    }


    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public Double getPresupuesto() {
        return presupuesto;
    }


    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }


    public int getTrabajador() {
        return trabajador;
    }


    public void setTrabajador(int trabajador) {
        this.trabajador = trabajador;
    }


    @Override
    public String toString() {
        return "Centro [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", presupuesto=" + presupuesto
                + ", trabajador=" + trabajador + "]";
    }

}
