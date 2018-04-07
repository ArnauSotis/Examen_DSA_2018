package Product;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager {
    List<Producto> listaProductos = new ArrayList<Producto>();
    List<Usuario> listaUsuarios =new ArrayList<Usuario>();
    List<Pedido> listaPedidosTotal = new LinkedList<Pedido>();
    // i per la llista de pedidos total
    int i = 0;
    // contadorPedidos per saber quin tamany te la llista de pedidos total
    int contadorPedidos = 0;

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger("myLogger");

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
    public void addUser (Usuario newUser) {
        listaUsuarios.add(newUser);
    }
    public void addProduct (Producto newProduct){
        listaProductos.add(newProduct);
    }

    public Usuario identificarse(String nombre){
        //logger.log(Level.SEVERE, "Nombre de usuario:");
        //String nombre = sc.nextLine();
        Usuario user = consultarUsuario(nombre);
        return user;
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
            if (userRegis.getNombre().equals(nombre)) {
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
    public boolean consultarProductoCatalogo (Producto p){
        boolean resp = false;
        for(Producto producComp: listaProductos){
            if (producComp.getNombre().equals(p.getNombre())) {
                resp = true;
            }
        }
        return resp;
    }
    public boolean consultarPedido (Pedido pedido){
        boolean resp=false;
        for(Producto producComp: pedido.productosList){
            resp = consultarProductoCatalogo(producComp);
        }
        return resp;
    }
/*
    public boolean realizarPedido (Usuario user, List<String> lista){
        // logger.info(pedido)

        List<String> realizarList = new ArrayList(lista);
        if(user==null){
            return false;
        }
        else {
            for (String product : realizarList) {
                Producto produc = consultarProducto(product);
                user.pedidoList.add(produc);
            }
            return true;
        }
    }
    */
    public List<Producto> listarProductos(){
        List<Producto> ordenarPorPrecio = new ArrayList<Producto>(listaProductos);
        Collections.sort(ordenarPorPrecio, Comparator.comparing(Producto::getPrecio));
        return ordenarPorPrecio;
    }
    public void añadirProductoVendido (Pedido pedido){
        List<Producto> productosList = pedido.productosList;
        List<String> numDeCadaProducto = pedido.numDeCadaProducto;
        int j=0;
        //sin size
        //while (productosList.get(j)!=null){

        //con size
        int x = productosList.size();
        while (j<x){
            Producto añadirProducto = productosList.get(j);
            //cuantas veces compra el producto
            String numeroDeCompra = numDeCadaProducto.get(j);
            int num = Integer.parseInt(numeroDeCompra);
            añadirProducto.incremento(num);
            j++;
        }


    }
    public boolean realizarPedido (String nombre, Pedido pedido){
        // logger.info(pedido)
        boolean resp = false;
        Usuario u = consultarUsuario(nombre);
        if (u==null){
            return resp;
        }
        else{
            pedido.setUsuario(nombre);
            resp = consultarPedido(pedido);
            if (resp==true){
                listaPedidosTotal.add(pedido);
                contadorPedidos++;
            }
            return resp;
        }
    }
    public Pedido servirPedido (){
        Pedido p = new Pedido();
        //sin el size
        //if (i<=contadorPedidos){
        //   p = listaPedidosTotal.get(i);
        //con size
        int x = listaPedidosTotal.size();
        if (i<x){
            //añadimos los productos comprados
            añadirProductoVendido(p);
            String nombreUser = p.getUsuario();
            Usuario u = consultarUsuario(nombreUser);
            if (u==null){
                p=null;
            }
            else{
                u.pedidoList.add(p);
                p.setPedidoRealizado(true);
            }
            i++;
            return p;
        }
        else{
            p=null;
            return p;
        }
    }

    public List<Producto> listadoPedidos(String nombre){
        //devuelve todos los productos dentro de todos los pedidos realizados por el usuario
        Usuario u = consultarUsuario(nombre);
        List<Producto> listaProductosUsuario = new ArrayList<Producto>();
        if (u == null){
            // enviar mensaje de usuario no existe
        }
        else{
            List<Pedido> listarPedidosUsuario = u.pedidoList;
            for (Pedido pedi: listarPedidosUsuario){
                //logger.log(Level.SEVERE,  pedi.getUsuario());
                //he intenato meter una lista dentro de otra para meter todos los productos.
                //Ahora em toca meter prodcuto por producto
                // listaProductosUsuario.add(pedi.productosList);
                int j=0;
                int x = pedi.productosList.size();
                while (j<x){
                    listaProductosUsuario.add(pedi.productosList.get(j));
                    j++;
                }

            }

        }
        return listaProductosUsuario;

    }

    public List<Producto> listadoProductosByVentas () {
        //ordenamos la lista de productoss por el numero de ventas
        List<Producto> listaOrdenadaVentas = new ArrayList(listaProductos);
        Collections.sort(listaOrdenadaVentas, Comparator.comparing(Producto::getNumeroVentas));
        //si pongo esta función hay un error en el producto que implementa esto
        //Collections.sort(listaOrdenadaVentas, Producto.CMP);

        Collections.reverse(listaOrdenadaVentas);
        return listaOrdenadaVentas;

        /*for (Producto product: listaProductos){
            logger.log(Level.SEVERE,  product.getNumeroVentas() +"  "+product.getNombre());
        }
        */
    }

    /*
    public List<Producto> servirPedidoRest(String user){
        for (Producto product: userPeddio.pedidoList){
            logger.log(Level.SEVERE, product.getNombre());
        }
        Usuario userPedido = consultarUsuario(user);
        List<Producto> listaServirPedido = userPedido.pedidoList;
        return listaServirPedido;
    }
    */
}
