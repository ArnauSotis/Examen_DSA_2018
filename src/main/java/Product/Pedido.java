package Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pedido {
    String usuario = null;

    boolean pedidoRealizado= false;

    public List<Producto> productosList = new LinkedList<Producto>();
    public List<String> numDeCadaProducto = new LinkedList<String>();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isPedidoRealizado() {
        return pedidoRealizado;
    }

    public void setPedidoRealizado(boolean pedidoRealizado) {
        this.pedidoRealizado = pedidoRealizado;
    }



}
