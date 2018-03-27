package main.java;

import java.util.LinkedList;

public class Usuario {
    String Nombre;

    public LinkedList<Producto> pedidoList = new LinkedList<Producto>();

    public Usuario (String nombre ){
        this.Nombre = nombre;

    }
    /*
    public void mostrarPorPantala() {
        System.out.println("NOMBRE: "+getNom());
    }
    */
    public String getNom() {
        return Nombre;
    }
    public void setNom(String Nom) {
        this.Nombre = Nom;
    }
}
