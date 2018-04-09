package Product;

public class LineaDePedido {
    private int num;
    private Producto p;

    protected LineaDePedido(Producto p, int num) {
        this.p = p;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public Producto getProducto() {
        return this.p;
    }
}
