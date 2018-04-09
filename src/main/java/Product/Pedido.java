package Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pedido {
    Usuario usuario = null;

    private boolean pedidoRealizado= false;

    //public List<Producto> productosList = new LinkedList<Producto>();
    //public List<String> numDeCadaProducto = new LinkedList<String>();
    private List<LineaDePedido> lp = null;

    public Pedido() {
      this.lp = new LinkedList<LineaDePedido>();

    }

    public void add (Producto pd, int num ){
       //this.productosList.add(pd);
       //this.numDeCadaProducto.add(num);

        this.lp.add(new LineaDePedido(pd, num));
    }

    public List<LineaDePedido> getListaDePedidos() {
        return this.lp;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean setPedidoRealizado() {
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
        return lp.equals(pedido.lp);
    }

    @Override
    public int hashCode() {
        int result = usuario.hashCode();
        result = 31 * result + (pedidoRealizado ? 1 : 0);
        result = 31 * result + lp.hashCode();
        return result;
    }
}
