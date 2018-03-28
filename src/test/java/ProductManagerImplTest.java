package test.java;

import main.java.ProductManagerImpl;
import main.java.Producto;
import main.java.Usuario;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductManagerImplTest {

        ProductManagerImpl p = new ProductManagerImpl();
        Usuario prueba = new Usuario("David");
        Producto prueba2 = new Producto("Patata",2.9);
        List<Usuario> listaUsuarios =new ArrayList<Usuario>();
        List<Producto> listaVentas =new ArrayList<Producto>();
        List<Producto> listaCompraUser =new ArrayList<Producto>();


        /*
    @Test
    public void consultarUsuarioTest () {
        Usuario respuestaReal = p.consultarUsuario("David");
        Usuario resultadoEsperado = prueba ;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void consultarProductoTest () {
        Producto respuestaReal = p.consultarProducto("Patata");
        Producto resultadoEsperado =  ;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void identificarseTest () {
        String a ="David";
        String resultadoReal = p.identificarse(a);
        String resultadoEsperado = "David";
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void realizarPedidoTest () {
        int resultadoReal = p.realizarPedido(prueba, prueba2);
        int resultadoEsperado = 1;
        assertEquals(resultadoEsperado, resultadoReal);
    }

     @Test
    public void servirPedidoTest () {
        List<Producto> resultadoreal = p.servirPedido(prueba);
        listaCompraUser.add(prueba2);
        List<Producto>resultadoEsperado = listaCompraUser ;
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void listadoPedidosTest () {
        List<Producto> resultadoreal = p.listadoPedidos();
        listaCompraUser.add(prueba2);
        List<Producto>resultadoEsperado = listaCompraUser ;
        assertEquals(resultadoEsperado, resultadoReal);
    }


    */

}
