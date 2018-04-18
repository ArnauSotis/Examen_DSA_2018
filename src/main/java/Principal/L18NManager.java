package Principal;


import java.util.HashMap;
import java.util.ResourceBundle;


public class L18NManager {
    private static L18NManager instance;
    private HashMap<String, ResourceBundle> data;


    private L18NManager(){
        data = new HashMap<String, ResourceBundle>();
    }

    public static L18NManager getInstance(){
        if (instance == null) instance = new L18NManager();
        return instance;
    }
    public String getText(String language, String Key){
        ResourceBundle rb = data.get(language);
        if (rb == null){
            rb = ResourceBundle.getBundle("en");
            data.put(language, rb);

        }
        return rb.getString(Key);
    }

    public static void main (String[] args) {
        String value = L18NManager.getInstance().getText("EN", "T1");
        System.out.println(value);
    }
}
