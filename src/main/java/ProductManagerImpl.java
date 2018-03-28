package main.java;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager{
    List<Producto> listaProductos = new ArrayList<Producto>();
    List<Producto> listaProductosVendidosTotal = new ArrayList<Producto>();
    List<Usuario> listaUsuarios =new ArrayList<Usuario>();

    //Scanner sc = new Scanner(System.in);
    //Logger logger = Logger.getLogger("myLogger");

    public void productosCreados() {
        //creamos algunos productos por defecto
        Producto produc1 = new Producto("Patata", 2.3);
        listaProductos.add(produc1);

        Producto produc2 = new Producto("Jamon", 9.5);
        listaProductos.add(produc2);

        Producto produc3 = new Producto("Zanahoria", 3.2);
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
    /*
    public void crearProducto (){
        logger.log(Level.SEVERE, "Nombre del producto:");
        String nombreProducto = sc.nextLine();
        logger.log(Level.SEVERE, "Precio del producto:");
        String precioProducto = sc.nextLine();
        double precio = Double.parseDouble(precioProducto);
        Producto produ = new Producto(nombreProducto, precio);
        listaProductos.add(produ);
    }
    */
    public Usuario consultarUsuario(String nombre) {
        for(Usuario userRegis: listaUsuarios){
            if (userRegis.getNom().equals(nombre)) {
                return userRegis;
            }
        }
        return null;

    }
    public Producto consultarProducto (String producto) {
        for(Producto producComp: listaProductos){
            if (producComp.getNombre().equals(producto)) {
                return producComp;
            }
        }
        return null;

    }
    public int realizarPedido (Usuario userRegis, String producto){
        Producto produ= consultarProducto(producto);
        userRegis.pedidoList.add(produ);
        listaProductosVendidosTotal.add(produ);
        produ.incremento();
        int resp=1;
        return resp;
    }
    public int realizarPedidoRest (Usuario userRegis, List<Producto> realizarList){
        int rp=0;
        for (Producto product: realizarList) {
            userRegis.pedidoList.add(product);
            listaProductosVendidosTotal.add(product);
            product.incremento();
            rp = 1;
        }
        return rp;

    }
    /*
    public boolean realizarPedido (Usuario userRegis){
        //como ya esta identificado nos pasan el nombre del usuario
        int conf=0;
        logger.log(Level.SEVERE, "Cuantos productos quieres comprar:");
        String contador = sc.nextLine();
        int cont = Integer.parseInt(contador);
        for (int i=0; i<cont; i++) {
            logger.log(Level.SEVERE, "Producto:");
            String nombreProducto = sc.nextLine();
            Producto produ= consultarProducto(nombreProducto);
            userRegis.pedidoList.add(produ);
            listaProductosVendidosTotal.add(produ);
            produ.incremento();
            conf++;
        }
        if (conf==cont){
            return true;
        }
        else return false;
    }
    */
    public List<Producto> listadoPedidos(){
        //ordenamos la lista de productoss por el numero de ventas
        List<Producto> listaOrdenadaVentas = listaProductos;
        Collections.sort(listaOrdenadaVentas, Comparator.comparing(Producto::getNumeroVentas));
        Collections.reverse(listaOrdenadaVentas);
        return listaOrdenadaVentas;

        /*for (Producto product: listaProductos){
            logger.log(Level.SEVERE,  product.getNumeroVentas() +"  "+product.getNombre());

        }
        */

    }
    public Usuario identificarse(String nombre){
        //logger.log(Level.SEVERE, "Nombre de usuario:");
        //String nombre = sc.nextLine();
        Usuario user = consultarUsuario(nombre);
        return user;
    }
    public List<Producto> servirPedido(Usuario userPeddio){
        /*for (Producto product: userPeddio.pedidoList){
            logger.log(Level.SEVERE, product.getNombre());
        }
        */
        List<Producto> listaServirPedido = userPeddio.pedidoList;
        return listaServirPedido;
    }
    public List<Producto> servirPedidoRest(String user){
        /*for (Producto product: userPeddio.pedidoList){
            logger.log(Level.SEVERE, product.getNombre());
        }
        */
        Usuario userPedido = consultarUsuario(user);
        List<Producto> listaServirPedido = userPedido.pedidoList;
        return listaServirPedido;
    }
}
