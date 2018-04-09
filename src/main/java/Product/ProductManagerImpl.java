package Product;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager {
    List<Producto> listaProductos = new ArrayList<Producto>();
    List<Usuario> listaUsuarios =new ArrayList<Usuario>();
    Queue<Pedido> listaPedidosTotal = new LinkedList<Pedido>();
    // contadorPedidos per saber quin tamany te la llista de pedidos total
    int contadorPedidos = 0;
    int i = 0;
    private int iniciadorRest =0;
    private int iniciadorTest=0;
    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger("myLogger");

    public void modIniciadorTest (){
        this.iniciadorTest=1;
    }
    public int getIniciadorTest(){
        return this.iniciadorTest;
    }
    public int getIniciadorRest (){
        return this.iniciadorRest;
    }
    public void modIniciadorRest (){
        this.iniciadorRest=1;
    }
    public void productosCreados() {
        //creamos algunos productos por defecto
        Producto produc1 = new Producto("Patata", 2.3);
        listaProductos.add(produc1);

        Producto produc2 = new Producto("Jamon", 9.5);
        listaProductos.add(produc2);

        Producto produc3 = new Producto("Zanahoria", 3.2);
        listaProductos.add(produc3);

        //Arrays.sort(new List[]{listaProductos});
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
        for(LineaDePedido producComp: pedido.getListaDePedidos()){
            resp = consultarProductoCatalogo(producComp.getProducto());
        }
        return resp;
    }

    public List<Producto> listarProductos(){
        List<Producto> ordenarPorPrecio = new ArrayList<Producto>(listaProductos);
        Collections.sort(ordenarPorPrecio, Comparator.comparing(Producto::getPrecio));
        return ordenarPorPrecio;
    }
    /*
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
    */
    public boolean realizarPedido (String nombre, Pedido pedido){
        // logger.info(pedido)
        boolean resp = false;
        Usuario u = consultarUsuario(nombre);
        if (u==null){
            return resp;
        }
        else{
            pedido.setUsuario(u);
            resp = consultarPedido(pedido);
            if (resp){
                listaPedidosTotal.add(pedido);
                contadorPedidos++;
            }
            return resp;
        }
    }

    public Pedido servirPedido (){

        Pedido p = null;
        p = listaPedidosTotal.poll();

        if (p==null) return p;

        Usuario u = p.getUsuario();
        List<LineaDePedido> lp = p.getListaDePedidos();
        int num = 0;
        Producto producto;

        for (LineaDePedido linea: lp) {
            num = linea.getNum();
            producto = linea.getProducto();

            producto.incrementar(num);
            logger.log(Level.SEVERE, "value =" + producto.getNumeroVentas());
        }
        u.addPedido(p);
        return p;
/*
        ////////
        int x = listaPedidosTotal.size();
            logger.log(Level.SEVERE,  "x");
        if (i<x){
            p = listaPedidosTotal.get(x-i);

           // p = listaPedidosTotal.pull();
            //p.getUsuario();

            //añadimos los productos comprados
            añadirProductoVendido(p);
            String nombreUser = p.getUsuario();
            Usuario u = consultarUsuario(nombreUser);
            if (u==null){
                return p;
            }
            else{
                u.pedidoList.add(p);
                p.setPedidoRealizado(true);
                logger.log(Level.SEVERE,  p.getUsuario());
                for (Producto product: p.productosList){
                    logger.log(Level.SEVERE,  product.getNombre());
                }
                i++;
                return p;
            }
        }
        else{
            return p;
        }*/
    }

    public List<Pedido> listadoPedidos(String nombre){
        List<Pedido> listarPedidosUsuario = null;
        //devuelve todos los productos dentro de todos los pedidos realizados por el usuario
        Usuario u = consultarUsuario(nombre);
        List<Producto> listaProductosUsuario = new ArrayList<Producto>();
        if (u == null){
            // enviar mensaje de usuario no existe
            return listarPedidosUsuario;
        }
        else{
            listarPedidosUsuario = u.consultaPedidos();
            return listarPedidosUsuario;
        }
    }

    public List<Producto> listadoProductosByVentas () {
        //ordenamos la lista de productoss por el numero de ventas
        List<Producto> listaOrdenadaVentas = new ArrayList(listaProductos);
        Collections.sort(listaOrdenadaVentas, Comparator.comparing(Producto::getNumeroVentas));
        //si pongo esta función hay un error en el producto que implementa esto
        //Collections.sort(listaOrdenadaVentas, Producto.CMP);

        Collections.reverse(listaOrdenadaVentas);
        for (Producto product: listaOrdenadaVentas){
            logger.log(Level.SEVERE,  product.getNombre()+ "    " + product.getNumeroVentas());
        }
        return listaOrdenadaVentas;
    }
}
