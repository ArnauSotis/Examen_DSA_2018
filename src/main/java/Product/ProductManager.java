package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface ProductManager {
    Usuario identificarse(String nombre);
    List<Producto> listarProductos();
    boolean realizarPedido (String nombre, Pedido pedido); //Usuario user, List<String> relizarList);
    Pedido servirPedido();
    List<Producto> listadoPedidos(String nombre);
    List<Producto> listadoProductosByVentas();



    Usuario consultarUsuario(String nombre);
    Producto consultarProducto (String producto);
    boolean consultarProductoCatalogo (Producto p);
    void addUser (Usuario newUser);
    void addProduct (Producto newProduct);

}
