//package test.java;

import Product.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ProductManagerImplTest {

    ProductManager p = null;

    @Before
    public void setUp() {
        this.p = Singleton.getInstance().getImpl();
        Usuario david = new Usuario("David2");
        Usuario juan = new Usuario("Juan");
        Producto patata = new Producto("Patata", 2.9);

        this.p.addUser(david);
        this.p.addUser(juan);
        this.p.addProduct(patata)


//        List<Producto> listaCompraUser = new ArrayList<Producto>();
    }

    @After
    public void tearDown() {
        //this.p.clear();
    }



    @Test
    public void consultarUsuarioTest() {
  ¡      Usuario resultadoReal = p.consultarUsuario("David2");
        assertEquals("David2", resultadoReal.getNom());
    }

    @Test
    public void consultarProductoTest() {
        Producto resultadoReal = p.consultarProducto("Patata");
        Producto resultadoEsperado = prueba2;
        assertEquals("Patata", resultadoReal.getNombre());
    }

/*    @Test
    public void identificarseTest() {
        p.usuariosExistentes();
        Usuario resultadoReal = p.identificarse("David2");
        Usuario resultadoEsperado = prueba;
        assertEquals(resultadoEsperado, resultadoReal);
    }
*/
    @Test
    public void realizarPedidoTest() {
        Pedido pedido = new Pedido();
        pedido.add(new Producto("patata",55), 20);
        pedido.add(new Producto("cafe",2), 5);
        pedido.add(new Producto("coca cola", 1.5), 3);
        p.realizarPedido("David2", pedido);


        /*



        p.usuariosExistentes();
        p.productosCreados();
        String producto1 ="Patata";
        List<String> real = new ArrayList<String>();
        real.add(producto1);
        boolean resultadoReal = p.realizarPedido(prueba, real);
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
*/
    }

    @Test
    public void consultarUsuario() {
       Usuario u = this.p.consultarUsuario("David2");
       assertEquals(u.getNom(), "David2");

       u = this.p.consultarUsuario("XXXXXXXXXX");
       assertNull(u);



    }



        @Test
    public void servirPedidoTest() {
        Pedido pedido1 = new Pedido();
        pedido1.add(new Producto("patata",55), 20);
        pedido1.add(new Producto("cafe",2), 5);
        pedido1.add(new Producto("coca cola", 1.5), 3);
        p.realizarPedido("David2", pedido1);

        Pedido pedido2 = new Pedido();
        pedido2.add(new Producto("bocata",55), 20);
        pedido2.add(new Producto("cafe",2), 5);
        pedido2.add(new Producto("coca cola", 1.5), 3);
        p.realizarPedido("Juan", pedido2);

        Pedido pedido3 = new Pedido();
        pedido3.add(new Producto("patata",55), 20);
        pedido3.add(new Producto("cafe",2), 5);
        pedido3.add(new Producto("coca cola", 1.5), 3);
        p.realizarPedido("David2", pedido3);

        Pedido p  = p.servirPedido();
        assert(p.owner().getNom(), "David2")

        p = p.servirPedido();
        //
        assert(p.owner().getNom(); "Juan")


        prueba.pedidoList.add(prueba2);
        List<Producto> resultadoReal = p.servirPedido(prueba);
        listaCompraUser.add(prueba2);
        List<Producto> resultadoEsperado = listaCompraUser;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void listadoPedidosTest() {
        //la lista de compras en el productmanager esta vacia no se que debo hacer
        List<Producto> resultadoReal = p.listadoPedidos();
        listaCompraUser.add(prueba2);
        List<Producto> resultadoEsperado = listaCompraUser;
        assertEquals(resultadoEsperado, resultadoReal);
    }

}
