/*package MainDeProducto;

import Product.ProductManager;
import Product.Producto;
import Product.Singleton;
import Product.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger("myLogger");


        ProductManager impl = Singleton.getInstance().getImpl();
        impl.productosCreados();
        impl.usuariosExistentes();
        List<String> productoList = new ArrayList<String>();

        logger.log(Level.SEVERE, "Nombre del Usuario:");
        String nomUser = sc.nextLine();
        Usuario userResgistrado = impl.identificarse(nomUser);
        logger.log(Level.SEVERE, "Cuantos productos quieres comprar:");
        String contador = sc.nextLine();
        int cont = Integer.parseInt(contador);
        boolean resp;
        for (int i = 0; i < cont; i++) {
            logger.log(Level.SEVERE, "Producto:");
            String nombreProducto = sc.nextLine();
            productoList.add(nombreProducto);
        }
        resp = impl.realizarPedido(userResgistrado, productoList);
        if (resp) {
            List<Producto> servirList = impl.servirPedido(userResgistrado);
            logger.log(Level.SEVERE, "Lista de los productos comprados.\n");
            for (Producto product : servirList) {
                logger.log(Level.SEVERE, product.getNombre());
            }
            List<Producto> ventasList = impl.listadoPedidos();
            logger.log(Level.SEVERE, "Numero de ventas de cada producto listado de mas vendido a menos.\n");
            for (Producto product : ventasList) {
                logger.log(Level.SEVERE, product.getNumeroVentas() + "  " + product.getNombre() + "  " + product.getPrecio() + "$");
            }
        } else {
            logger.log(Level.SEVERE, "Error al introducir un pedido en el pedido.\n");
        }
    }
}
*/