package main.java;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagerImpl {
    List<Producto> listaProductos = new ArrayList<Producto>();
    List<Producto> listaProductosVendidosTotal = new ArrayList<Producto>();
    List<Usuario> listaUsuarios =new ArrayList<Usuario>();
    List<Producto> listaVendidosUser = new ArrayList<Producto>();

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger("myLogger");

    public void productosCreados() {
        //creamos algunos productos por defecto
        Producto produc1 = new Producto("Patata", 2.3);
        listaProductos.add(produc1);

        Producto produc2 = new Producto("Jamón", 9.5);
        listaProductos.add(produc2);

        Producto produc3 = new Producto("Zanaoria", 3.2);
        listaProductos.add(produc3);

        Arrays.sort(new List[]{listaProductos});
    }
    public void usuariosExistentes() {
        //creamos algunos usuarios por defecto
        Usuario user1 = new Usuario("David");
        listaUsuarios.add(user1);
        Usuario user2 = new Usuario("Arnau");
        listaUsuarios.add(user2);

    }

    public void crearProducto (){
        logger.log(Level.SEVERE, "Nombre del producto:");
        String nombreProducto = sc.nextLine();
        logger.log(Level.SEVERE, "Precio del producto:");
        String precioProducto = sc.nextLine();
        double precio = Double.parseDouble(precioProducto);
        Producto produ = new Producto(nombreProducto, precio);
        listaProductos.add(produ);
    }
    public void realizarPedido (String nombreUsuario){
        //como ya esta identificado nos pasan el nombre del usuario
        Usuario userRegis = new Usuario(nombreUsuario);
        logger.log(Level.SEVERE, "Cuantos productos quieres comprar:");
        String contador = sc.nextLine();
        int cont = Integer.parseInt(contador);
        for (int i=0; i<cont; i++) {
            logger.log(Level.SEVERE, "Producto:");
            String nombreProducto = sc.nextLine();
            for(Producto producComp: listaProductos){
                if (producComp.getNombre().equals(nombreProducto)) {
                    userRegis.pedidoList.add(producComp);
                    listaProductosVendidosTotal.add(producComp);
                    producComp.incremento();
                }
            }
        }
    }
    public void listadoPedidos(){
        Collections.sort(listaProductos, Comparator.comparing(Producto::getNumeroVentas));
        Collections.reverse(listaProductos);
        for (Producto product: listaProductos){
            logger.log(Level.SEVERE, product.getNombre());
        }

    }
    public String Identificarse(){
        logger.log(Level.SEVERE, "Nombre de usuario:");
        String nombre = sc.nextLine();
        String result; int confirm=0;
        for(Usuario userComp: listaUsuarios){
            if (userComp.getNom().equals(nombre)) {
                confirm=1;
            }
        }
        if (confirm==1){
            result=nombre;
            return result;
        }
        else{
            result = "NO";
            return result;
        }



    }
    public void servirPedido(String userPeddio){
        for(Usuario userComp: listaUsuarios){
            if (userComp.getNom().equals(userPeddio)) {
                listaVendidosUser = userComp.pedidoList;
            }
        }
        for (Producto product: listaVendidosUser){
            logger.log(Level.SEVERE, product.getNombre());
        }

    }
}
