package Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pedido {
    String usuario = null;

    boolean pedidoRealizado= false;

    public List<Producto> productosList = new LinkedList<Producto>();
    public List<String> numDeCadaProducto = new LinkedList<String>();

    public void add (Producto pd, String num ){
        this.productosList.add(pd);
        this.numDeCadaProducto.add(num);

    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (pedidoRealizado != pedido.pedidoRealizado) return false;
        if (!usuario.equals(pedido.usuario)) return false;
        if (!productosList.equals(pedido.productosList)) return false;
        return numDeCadaProducto.equals(pedido.numDeCadaProducto);
    }

    @Override
    public int hashCode() {
        int result = usuario.hashCode();
        result = 31 * result + (pedidoRealizado ? 1 : 0);
        result = 31 * result + productosList.hashCode();
        result = 31 * result + numDeCadaProducto.hashCode();
        return result;
    }

}
