package main.java;

public class Producto {
    private String Nombre;
    private double Precio;
    private int NumeroVentas=0;

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
