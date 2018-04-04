package Product;
import java.util.*;

public class ProductManagerImpl implements ProductManager {
    List<Producto> listaProductos = new ArrayList<Producto>();
    List<Usuario> listaUsuarios =new ArrayList<Usuario>();
    List<Pedido> listaPedidosTotal = new LinkedList<Pedido>();
    // i per la llista de pedidos total
    int i = 0;
    // contadorPedidos per saber quin tamany te la llista de pedidos total
    int contadorPedidos = 0;

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
    public void añadirProductoVendido (Pedido pedido){
        List<Producto> productosList = pedido.productosList;
        List<String> numDeCadaProducto = pedido.numDeCadaProducto;

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
        if (i<=contadorPedidos){
            p = listaPedidosTotal.get(i);
            //añadimos los productos comprados
            añadirProductoVendido(p);
            String nombreUser = p.getUsuario();
            Usuario u = consultarUsuario(nombreUser);
            u.pedidoList.add(p);
            p.setPedidoRealizado(true);
            return p;
        }
        else{
            p=null;
            return p;
        }
    }


    public List<Producto> listadoPedidos(String nombre){


    }

    public List<Producto> listadoProductosByVentas (){
        //ordenamos la lista de productoss por el numero de ventas
        List<Producto> listaOrdenadaVentas = new ArrayList(listaProductos);
        Collections.sort(listaOrdenadaVentas, Comparator.comparing(Producto::getNumeroVentas));

        //Collections.sort(listaOrdenadaVentas, Producto.CMP);

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
