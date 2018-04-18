package Principal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.beans.Expression;

@Path("/json")
public class JSONService {

        protected MathManagerImpl mathManagerImpl;

        public JSONService() {

            this.mathManagerImpl = Singleton.getInstance().getMi();

        }

        @GET
        @Path("/operacion/{nombre}/{numero1}/{numero2}/{operacion}")
        @Produces(MediaType.APPLICATION_JSON)
        public int getResult(@PathParam("nombre") String nombreAlumno,@PathParam("numero1") int numero1,@PathParam("numero2") int numero2, @PathParam("operacion") int operacion){
          Alumno alumno = new Alumno();
          alumno.setNombre(nombreAlumno);
          alumno.setNumeroOperaciones();
          return mathManagerImpl.realizarOperacionAlumno(alumno, numero1,numero2,operacion);
        }

        //realizar un pedido (una comra)
       /* @POST
        @Path("/operacion/{nombre}/{numero1}/{numero2}/{operacion}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response getResult(@PathParam("nombre") String nombreAlumno,@PathParam("numero1") int numero1,@PathParam("numero2") int numero2, @PathParam("operacion") int operacion) {
            //Pedido p = null;
            //p.setListaDePedidos(pedido);

            //      return Response.status(201).entity("Pedio preparado para realizar").build();


            return Response.status(409).entity("Error de compra").build();

        }*/
        }


