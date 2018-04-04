package Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    String nombre;

    public List<Pedido> pedidoList = new LinkedList<Pedido>();

    public Usuario (String nombre ){
        this.nombre = nombre;

    }
    /*
    public void mostrarPorPantala() {
        System.out.println("NOMBRE: "+getNom());
    }
    */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nom) {
        this.nombre = Nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return nombre.equals(usuario.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
