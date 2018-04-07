package Product;

import java.util.Comparator;

public class Producto {
    private String nombre;
    private double precio;
    private int numeroVentas=0;

    /*
    public static Comparator<Producto> CMP = new Comparator<Producto>(){
        @Override
        public int compare(Producto o1, Producto o2) {
            return o2.numeroVentas-o1.numeroVentas;
        }
    }
    */

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    public void incremento (int x){
        numeroVentas = numeroVentas + x;
    }
    /*
    public void mostrarPorPantalaProducto() {
        System.out.println("NOMBRE: "+getNombre());
        System.out.println("Precio: "+getPrecio());
        System.out.println("Numero de ventas: "+getNumeroVentas());
    }
    */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nom) {
        this.nombre = Nom;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double Pre) {
        this.precio = Pre;
    }
    public int getNumeroVentas(){
        return numeroVentas;
    }
    public void setNumeroVentas( int ven){
        this.numeroVentas = ven;
    }

}
