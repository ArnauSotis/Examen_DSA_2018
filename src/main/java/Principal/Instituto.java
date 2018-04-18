package Principal;

import java.util.ArrayList;
import java.util.List;

public class Instituto {

    private String nombre;
    private int numeroOperaciones;
    List<Alumno> alumnos = new ArrayList<>();

    public Instituto(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroOperaciones() {
        return numeroOperaciones;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void setNumeroOperaciones(int numeroOperaciones) {
        int numerototal=0;

        for(Alumno alumno : alumnos)
        {
            numerototal=numerototal+alumno.getNumeroOperaciones();
        }
    }


}
