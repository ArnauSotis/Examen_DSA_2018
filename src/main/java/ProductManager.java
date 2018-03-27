package main.java;

public interface ProductManager {

    class ArranqueInterfaz
    {
        public static void main(String arg[])
        {

            ProductManagerImpl impl = Singleton.getInstance().getImpl();
            impl.productosCreados();
            String user = impl.Identificarse();
            impl.realizarPedido(user);
            impl.servirPedido(user);
            impl.listadoPedidos();

        }
    }
}
