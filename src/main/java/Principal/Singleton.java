package Principal;

public class Singleton {

        private static Singleton instance;
        private Singleton() {
            // Exists only to defeat instantiation.
        }
        public static Singleton getInstance() {
            if(instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

     /*   private ProductManagerImpl impl = new ProductManagerImpl();

    public ProductManagerImpl getImpl() {
        return impl;
    }*/
    private MathManagerImpl mi = new MathManagerImpl();

    public MathManagerImpl getMi() {
        return mi;
    }
    private ReversePolishNotationImpl pI = new ReversePolishNotationImpl();

   public ReversePolishNotationImpl getPolish(){
       return pI;
   }


}


