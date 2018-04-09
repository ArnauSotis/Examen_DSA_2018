//package test.java;

import Product.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ProductManagerImplTest {

    ProductManager p = null;
    Producto patata = null;
    Producto cafe = null;
    Producto cocaCola = null;

    @Before
    public void setUp() {
        this.p = Singleton.getInstance().getImpl();
        Usuario david = new Usuario("David2");
        Usuario juan = new Usuario("Juan");
        this.patata = new Producto("Patata", 55);
        this.cafe = new Producto("cafe", 2);
        this.cocaCola = new Producto("coca cola", 1.5);

        this.p.addUser(david);
        this.p.addUser(juan);
        this.p.addProduct(patata);
        this.p.addProduct(cafe);
        this.p.addProduct(cocaCola);


//        List<Producto> listaCompraUser = new ArrayList<Producto>();
    }

    @After
    public void tearDown() {
        //this.p.clear();
    }



    @Test
    public void consultarUsuarioTest() {
        Usuario resultadoReal = p.consultarUsuario("David2");
        assertEquals("David2", resultadoReal.getNombre());
    }

    //consultar producto por Producto el que es por string no hace falta
    @Test
    public void consultarProductoTest() {
        Producto patata = new Producto("Patata", 2.9);
        boolean resultadoReal = p.consultarProductoCatalogo(patata);
        assertEquals(true, resultadoReal);
    }
    @Test
    public void consultarUsuario() {
        Usuario u = this.p.consultarUsuario("David2");
        assertEquals(u.getNombre(), "David2");

        u = this.p.consultarUsuario("XXXXX");
        assertNull(u);

    }
    @Test
    public void identificarseTest() {
        Usuario resultadoReal = this.p.identificarse("David2");
        Usuario david = new Usuario("David2");
        assertEquals(david, resultadoReal);

        //Ha de devolver null
        Usuario error = p.identificarse("XXXXX");
        assertNull(error);
    }

    @Test
    public void listarProductosTest() {
        List<Producto> listarProductos = this.p.listarProductos();
        assertEquals("coca cola", listarProductos.get(0).getNombre());

        Producto patata = this.patata;
        Producto cafe = this.cafe;
        Producto cocaCola = this.cocaCola;
        List<Producto> ordenadaPorPrecio = new ArrayList<Producto>();
        ordenadaPorPrecio.add(patata);
        ordenadaPorPrecio.add(cafe);
        ordenadaPorPrecio.add(cocaCola);
        Collections.sort(ordenadaPorPrecio, Comparator.comparing(Producto::getPrecio));
        assertEquals(ordenadaPorPrecio.size(), listarProductos.size());
        assertEquals("coca cola", listarProductos.get(0).getNombre());

    }

    @Test
    public void realizarPedidoTest() {
        //intente hacer una lista de int pero no me deja
        //asi que hago de string y despues lo convierto a int
        Producto patata = this.p.consultarProducto("Patata");
        Producto cafe = this.p.consultarProducto("cafe");
        Producto cocaCola = this.p.consultarProducto("coca cola");
        Pedido pedido = new Pedido();

        pedido.add(patata, 20);
        pedido.add(cafe, 5);
        pedido.add(cocaCola, 3);
        /*
        pedido.add(new Producto("Patata",55), "20");
        pedido.add(new Producto("cafe",2), "5");
        pedido.add(new Producto("coca cola", 1.5), "3");
        */
        boolean result = this.p.realizarPedido("David2", pedido);
        assertEquals(true, result);

        //usuario no existe
        Pedido pedido2 = new Pedido();
        pedido2.add(new Producto("patata",55), 20);
        pedido2.add(new Producto("cafe",2), 5);
        pedido2.add(new Producto("coca cola", 1.5), 3);
        boolean result2 = this.p.realizarPedido("XXXXX", pedido2);
        assertEquals(false, result2);

        //producto no existe
        Pedido pedido3 = new Pedido();
        pedido3.add(new Producto("patata",55), 20);
        pedido3.add(new Producto("cafe",2), 5);
        pedido3.add(new Producto("XXXXX", 1.5), 3);
        boolean result3 = this.p.realizarPedido("David2", pedido3);
        assertEquals(false, result3);

    }


    @Test
    public void servirPedidoTest() {

        Pedido pedido1 = new Pedido();
        pedido1.add(new Producto("Patata", 55), 20);
        pedido1.add(new Producto("cafe", 2), 5);
        pedido1.add(new Producto("coca cola", 1.5), 3);
        this.p.realizarPedido("David2", pedido1);

        Pedido pedido2 = new Pedido();
        pedido2.add(new Producto("Patata", 55), 20);
        pedido2.add(new Producto("cafe", 2), 5);
        pedido2.add(new Producto("coca cola", 1.5), 3);
        this.p.realizarPedido("Juan", pedido2);

        Pedido pedido3 = new Pedido();
        pedido3.add(new Producto("Patata", 55), 20);
        pedido3.add(new Producto("cafe", 2), 5);
        pedido3.add(new Producto("coca cola", 1.5), 3);
        this.p.realizarPedido("David2", pedido3);



        Pedido x  = this.p.servirPedido();
        assertEquals(x.getUsuario().getNombre(), "David2");
        assertEquals(pedido1.getUsuario(), x.getUsuario());

        x = this.p.servirPedido();
        assertEquals(pedido2.getUsuario(), x.getUsuario());
        assertEquals(x.getUsuario().getNombre(), "Juan");
        //assertEquals(pedido2, x);

        x = this.p.servirPedido();
        assertEquals(pedido3.getUsuario(), x.getUsuario());
        assertEquals(x.getUsuario().getNombre(), "David2");
        //assertEquals(pedido3, x);

        //ahora con error en el nombre de usuario
         Pedido pedido4 = new Pedido();
         pedido4.add(new Producto("Patata",55), 20);
         pedido4.add(new Producto("cafe",2), 5);
         pedido4.add(new Producto("coca cola", 1.5), 3);
         this.p.realizarPedido("XXXXX", pedido4);
        //es del pedido 4 (usuario no existe)
        x = this.p.servirPedido();
        assertNull(x);
    }


    @Test
    public void listadoProductosByVentasTest() {
        //la lista de compras en el productmanager esta vacia no se que debo hacer
        Pedido pedido1 = new Pedido();
        pedido1.add(this.p.consultarProducto("Patata"), 20);
        pedido1.add(this.p.consultarProducto("cafe"), 5);
        pedido1.add(this.p.consultarProducto("coca cola"), 3);
        this.p.realizarPedido("David2", pedido1);
        Pedido pedidoServido = this.p.servirPedido();


        List<Producto> listaVendidos = this.p.listadoProductosByVentas();
        assertEquals("Patata",listaVendidos.get(0).getNombre());
        assertEquals(listaVendidos.get(0).getNumeroVentas(), 20);


        assertEquals("cafe",listaVendidos.get(1).getNombre());
        assertEquals("coca cola",listaVendidos.get(2).getNombre());
    }

}
