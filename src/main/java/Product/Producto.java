package Product;

import java.util.Comparator;

public class Producto {
    private String Nombre;
    private double Precio;
    private int NumeroVentas=0;

    public static Comparator<Producto> CMP = new Comparator<Producto>(){
        @Override
        public int compare(Producto o1, Producto o2) {
            return o2.NumeroVentas-o1.NumeroVentas;
        }
    }

    public Producto(String nombre, double precio){
        this.Nombre = nombre;
        this.Precio = precio;
    }
    public void incremento (){
        NumeroVentas++;
    }
    /*
    public void mostrarPorPantalaProducto() {
        System.out.println("NOMBRE: "+getNombre());
        System.out.println("Precio: "+getPrecio());
        System.out.println("Numero de ventas: "+getNumeroVentas());
    }
    */
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nom) {
        this.Nombre = Nom;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double Pre) {
        this.Precio = Pre;
    }
    public int getNumeroVentas(){
        return NumeroVentas;
    }
    public void setNumeroVentas( int ven){
        this.NumeroVentas = ven;
    }

}
