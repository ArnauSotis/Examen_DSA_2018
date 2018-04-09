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
            this.productManagerImpl = Singleton.getInstance().getImpl();
            int x = this.productManagerImpl.getIniciadorRest();
            if (x==0) {
                productManagerImpl.productosCreados();
                productManagerImpl.usuariosExistentes();
                String nombre = "David";
                Producto produc1 = this.productManagerImpl.consultarProducto("Patata");
                Producto produc2 = this.productManagerImpl.consultarProducto("Jamon");
                Pedido p = new Pedido();

                p.add(produc1,1);
                p.add(produc2,3);

                productManagerImpl.realizarPedido(nombre, p);
                productManagerImpl.modIniciadorRest();
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
        public List<Pedido> getListar(@PathParam("user") String user) {
            return productManagerImpl.listadoPedidos(user);
        }

        //realizar un pedido (una comra)
        @POST
        @Path("/compra/{user}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response compra (@PathParam("user") String user, Pedido pedido) {
        //public Response compra (@PathParam("user") String user, LinkedList pedido) {
            //Pedido p = null;
            //p.setListaDePedidos(pedido);
            boolean col  = productManagerImpl.realizarPedido(user, pedido);
            if (col){
                return Response.status(201).entity("Pedio preparado para realizar").build();
            }
            else{
                return Response.status(409).entity("Error de compra").build();
            }

        }

}
