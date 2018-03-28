package main.java;

import java.util.List;
import javax.sound.midi.Track;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class JSONService {

        protected List<Track> tracks;

        protected ProductManagerImpl productManagerImpl;

        public JSONService() {
            productManagerImpl = Singleton.getInstance().getImpl();
        }

        @GET
        @Path("/user/{nom}")
        @Produces(MediaType.APPLICATION_JSON)
        public Usuario getUser(@PathParam("nom") String nom) {
            return productManagerImpl.identificarse(nom);
        }
        @GET
        @Path("/servir/{usuario}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Producto> getServir(@PathParam("usuario") String usuario) {
            return productManagerImpl.servirPedidoRest(usuario);
        }
        @GET
        @Path("/listar")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Producto> getListar() {
            return productManagerImpl.listadoPedidos();
        }
        @POST
        @Path("/compra/{user}/{list}")
        @Consumes(MediaType.APPLICATION_JSON)
        //public Response (@PathParam("user") String user,@PathParam("list") List<Producto> list) {
        public Response compra (Usuario user, List<Producto> list) {
            int colleja = productManagerImpl.realizarPedidoRest(user, list);
            if (colleja==1){
                return Response.status(201).entity("Pedio preparado para realizar").build();
            }
            else{
                return Response.status(409).entity("Error de compra").build();
            }

        }

}
