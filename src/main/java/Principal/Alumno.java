package Principal;

public class Alumno {

    private String nombre;
    private int numeroOperaciones;
    public Alumno(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroOperaciones() {
        return numeroOperaciones;
    }

    public void setNumeroOperaciones() {
        this.numeroOperaciones++;
    }
}
