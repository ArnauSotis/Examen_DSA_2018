package main.java;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface ProductManager {

    class ArranqueInterfaz
    {
        public static void main(String arg[])
        {
            Scanner sc = new Scanner(System.in);
            Logger logger = Logger.getLogger("myLogger");


            ProductManagerImpl impl = Singleton.getInstance().getImpl();
            impl.productosCreados();
            impl.usuariosExistentes();
            logger.log(Level.SEVERE, "Nombre del Usuario:");
            String nomUser = sc.nextLine();
            Usuario userResgistrado = impl.identificarse(nomUser);
            logger.log(Level.SEVERE, "Cuantos productos quieres comprar:");
            String contador = sc.nextLine();
            int cont = Integer.parseInt(contador);
            int resp=0; int respTeorica=1;
            for (int i=0; i<cont; i++) {
                logger.log(Level.SEVERE, "Producto:");
                String nombreProducto = sc.nextLine();
                resp = impl.realizarPedido(userResgistrado, nombreProducto);
            }
            if (resp==respTeorica){
                List<Producto> servirList = impl.servirPedido(userResgistrado);
                logger.log(Level.SEVERE, "Lista de los productos comprados.\n");
                for (Producto product: servirList) {
                    logger.log(Level.SEVERE, product.getNombre());
                }
                List<Producto> ventasList = impl.listadoPedidos();
                logger.log(Level.SEVERE, "Numero de ventas de cada producto listado de mas vendido a menos.\n");
                for (Producto product: ventasList) {
                    logger.log(Level.SEVERE, product.getNumeroVentas() + "  " + product.getNombre() +"  " + product.getPrecio()+"$");
                }
            }
            else{
                logger.log(Level.SEVERE, "Error al introducir un pedido en el pedido.\n");
            }

                /*
            boolean respuesta= impl.realizarPedido(userResgistrado);
            if (respuesta==true){
                impl.servirPedido(userResgistrado);
                impl.listadoPedidos();
            }
            else{
                return;
            }
            */

        }
    }
}
