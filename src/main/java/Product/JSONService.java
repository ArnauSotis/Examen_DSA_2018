package Product;

import java.util.LinkedList;
import java.util.List;
import javax.sound.midi.Track;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class JSONService {

        protected ProductManagerImpl productManagerImpl;

        public JSONService() {
            productManagerImpl = Singleton.getInstance().getImpl();

            if (productManagerImpl.iniciadorRest==0) {
                productManagerImpl.productosCreados();
                productManagerImpl.usuariosExistentes();
                String nombre = "David";
                String n1 = "2";
                String n2 = "5";
                Producto produc1 = new Producto("Patata", 2.3);
                Producto produc2 = new Producto("Jamon", 3);
                Pedido p = new Pedido();
                p.productosList.add(produc1);
                p.productosList.add(produc2);
                p.numDeCadaProducto.add(n1);
                p.numDeCadaProducto.add(n2);
                productManagerImpl.realizarPedido(nombre, p);
                productManagerImpl.iniciadorRest=1;
            }

        }
        //para identificarse
        @GET
        @Path("/user/{nom}")
        @Produces(MediaType.APPLICATION_JSON)
        public Usuario getUser(@PathParam("nom") String nom) {
            return productManagerImpl.identificarse(nom);
        }

        //lista los productos por precio que hay en el catalogo
        @GET
        @Path("/listarProductos")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Producto> getListarProductos() {
            List<Producto> listarProductosPorPrecio = null;
            listarProductosPorPrecio = productManagerImpl.listarProductos();
            return listarProductosPorPrecio;
        }

        //servir un pedido por orden
        @GET
        @Path("/servir")
        @Produces(MediaType.APPLICATION_JSON)
        public Pedido getServir() {
            Pedido p = productManagerImpl.servirPedido();
            return p;
        }
        //listar los productos por numero de ventas
        @GET
        @Path("/ventas")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Producto>  getProductosPorNumeroDeVentas() {
            return productManagerImpl.listadoProductosByVentas();
        }
        //lista pedidos de un usuario
        @GET
        @Path("/listar/{user}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Producto> getListar(@PathParam("user") String user) {
            return productManagerImpl.listadoPedidos(user);
        }

        //listar producto por numero de ventas


        //realizar un pedido (una comra)
        @POST
        @Path("/compra/{user}")
        @Consumes(MediaType.APPLICATION_JSON)
        //public Response (@PathParam("user") String user,@PathParam("list") List<Producto> list) {
        public Response compra (@PathParam("user") String user, Pedido pedido) {
            boolean col  = productManagerImpl.realizarPedido(user, pedido);
            if (col){
                return Response.status(201).entity("Pedio preparado para realizar").build();
            }
            else{
                return Response.status(409).entity("Error de compra").build();
            }

        }

}
